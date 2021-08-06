package com.od.serviceImpl;

import com.od.dto.TransactionDTO;
import com.od.dto.customer.MetaDTO;
import com.od.enums.OrderStatusDescType;
import com.od.enums.OrderStatusType;
import com.od.model.Transaction;
import com.od.repository.OrderRepository;
import com.od.requestModel.CreateOrderRequest;
import com.od.requestModel.SubmitOrdersRequestModel;
import com.od.responseModel.*;
import com.od.service.BackendService;
import com.od.service.MiddlewareService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.Optional;

@Service
public class MiddlewareServiceImpl implements MiddlewareService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BackendService backendService;

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

    public SearchOrderResponseModel searchOrder () {

        return null;
    }
}
