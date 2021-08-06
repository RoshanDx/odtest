package com.od.serviceImpl;

import com.od.dto.TransactionDTO;
import com.od.dto.customer.MetaDTO;
import com.od.enums.OrderStatusDescType;
import com.od.enums.OrderStatusType;
import com.od.model.Transaction;
import com.od.repository.OrderRepository;
import com.od.requestModel.CreateOrderRequest;
import com.od.requestModel.SubmitOrdersRequestModel;
import com.od.responseModel.CreateOrderResponseModel;
import com.od.responseModel.GetCustomerResponseModel;
import com.od.responseModel.GetCustomerRoleResponseModel;
import com.od.responseModel.RetrieveUserResponseModel;
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
        responseModel.setMeta(new MetaDTO(200));
        responseModel.setCustomer(customerResponseModel.getCustomer());
        responseModel.setRoles(customerRoleResponseModel.getRoles());

        return responseModel;
    }

    public TransactionDTO updateOrderStatus(Long transactionId, OrderStatusType status, String remarks) {
        Transaction transaction = orderRepository.findOrderByTransactionId(transactionId);

        ModelMapper mapper = new ModelMapper();
        TransactionDTO responseModel = mapper.map(transaction, TransactionDTO.class);

        responseModel.setStatus(status);
        responseModel.setRemarks(remarks);
        responseModel.setLastUpdated(new Date());

        orderRepository.save(mapper.map(responseModel, Transaction.class));
        return responseModel;
    }

}
