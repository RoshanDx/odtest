package com.od.serviceImpl;

import com.od.dto.transaction.TransactionDTO;
import com.od.dto.customer.MetaDTO;
import com.od.enums.OrderStatusDescType;
import com.od.enums.OrderStatusType;
import com.od.model.Transaction;
import com.od.model.TransactionPage;
import com.od.repository.OrderPageableRepository;
import com.od.repository.OrderRepository;
import com.od.requestModel.CreateOrderRequest;
import com.od.requestModel.SubmitOrdersRequestModel;
import com.od.responseModel.*;
import com.od.service.BackendService;
import com.od.service.MiddlewareService;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MiddlewareServiceImpl implements MiddlewareService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BackendService backendService;

    @Autowired
    OrderPageableRepository orderPageRepository;

    public CreateOrderResponseModel createOrder(CreateOrderRequest createOrderRequest){

        CreateOrderResponseModel responseModel = new CreateOrderResponseModel();

        MetaDTO metaDTO = new MetaDTO();
        metaDTO.setCode(HttpStatus.OK.value());

        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setStatus(OrderStatusType.SUBMITTED);
        transactionDTO.setStatusDesc(OrderStatusDescType.SUBMITTED);
        transactionDTO.setCreated(new Date());
        transactionDTO.getOrders().addAll(createOrderRequest.getOrders());

        responseModel.setMetaDTO(metaDTO);
        responseModel.setTransaction(transactionDTO);

        ModelMapper mapper = new ModelMapper();
        Transaction tx = mapper.map(transactionDTO, Transaction.class);

        orderRepository.save(tx);

        responseModel.getTransaction().setTrxRefId(tx.getTrxRefId());

        SubmitOrdersRequestModel submitOrdersRequestModel = new SubmitOrdersRequestModel();
        submitOrdersRequestModel.setCustomerId(createOrderRequest.getCustomer().getId());
        submitOrdersRequestModel.getOrder().addAll(createOrderRequest.getOrders());

        HttpStatus submitOrderStatus = backendService.submitOrder(submitOrdersRequestModel);

        if (submitOrderStatus.equals(HttpStatus.OK)) {
            tx.setStatus(OrderStatusType.INPROGRESS);
            tx.setStatusDesc(OrderStatusDescType.INPROGRESS);
            responseModel.getTransaction().setStatus(OrderStatusType.INPROGRESS);
            responseModel.getTransaction().setStatusDesc(OrderStatusDescType.INPROGRESS);

            orderRepository.save(tx);
        }
        return responseModel;

    }

    public RetrieveUserResponseModel retrieveUser(String idType, String idNumber) {

        GetCustomerResponseModel customerResponseModel = backendService.retrieveUser(idType, idNumber);
        GetCustomerRoleResponseModel customerRoleResponseModel = backendService.getCustomerRole(customerResponseModel.getCustomer().getId());

        RetrieveUserResponseModel responseModel = new RetrieveUserResponseModel();
        MetaDTO metaDTO = new MetaDTO();
        if(customerRoleResponseModel != null) {

            metaDTO.setCode(HttpStatus.OK.value());

            responseModel.setMeta(metaDTO);
            responseModel.setCustomer(customerResponseModel.getCustomer());
            responseModel.setRoles(customerRoleResponseModel.getRoles());
        }

        return responseModel;
    }

    public UpdateOrderStatusResponseModel updateOrderStatus(Long transactionId, OrderStatusType status, OrderStatusDescType statusDesc, String remarks) {

        Transaction transaction = orderRepository.findOrderByTransactionId(transactionId);

        UpdateOrderStatusResponseModel responseModel = new UpdateOrderStatusResponseModel();

        ModelMapper mapper = new ModelMapper();

        if(transaction != null) {
            MetaDTO metaDTO = new MetaDTO();
            metaDTO.setCode(HttpStatus.OK.value());

            TransactionDTO transactionDTO = mapper.map(transaction, TransactionDTO.class);

            transactionDTO.setStatus(status);
            transactionDTO.setStatusDesc(statusDesc);
            transactionDTO.setRemarks(remarks);
            transactionDTO.setLastUpdated(new Date());
            responseModel.setMeta(metaDTO);
            responseModel.setTransaction(transactionDTO);

            orderRepository.save(mapper.map(responseModel.getTransaction(), Transaction.class));
        }

        return responseModel;
    }

    public SearchOrderResponseModel getOrders (TransactionPage transactionPage) {

        Pageable pageable = PageRequest.of(transactionPage.getStartRecord() - 1, transactionPage.getRecordLimit());

        DateTime maxDateTime = new DateTime(transactionPage.getStartDate()).plusDays(7);
        Date startDate = transactionPage.getStartDate();
        Date endDate = maxDateTime.toDate();

        if(startDate.before(endDate)) {
            endDate = transactionPage.getEndDate();
        }
        else {
            endDate = maxDateTime.toDate();
        }

        List<Transaction> transactions = orderRepository.getOrders(
                startDate,
                endDate,
                transactionPage.getStatusCode(),
                pageable
                );

        List<TransactionDTO> transactionsList =  transactions.stream().map(x->{
            ModelMapper mapper = new ModelMapper();
            return mapper.map(x, TransactionDTO.class);
        }).collect(Collectors.toList());

        SearchOrderResponseModel responseModel = new SearchOrderResponseModel();

        if(!transactions.isEmpty()) {
            responseModel.setMetaDTO(new MetaDTO(HttpStatus.OK.value(), transactions.size()));
            responseModel.setTransactions(transactionsList);
        }

        return responseModel;
    }
}
