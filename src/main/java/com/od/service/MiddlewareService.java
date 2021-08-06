package com.od.service;

import com.od.dto.TransactionDTO;
import com.od.enums.OrderStatusDescType;
import com.od.enums.OrderStatusType;
import com.od.requestModel.CreateOrderRequest;
import com.od.responseModel.CreateOrderResponseModel;
import com.od.responseModel.RetrieveUserResponseModel;
import com.od.responseModel.UpdateOrderStatusResponseModel;

import java.text.ParseException;

public interface MiddlewareService {

    CreateOrderResponseModel createOrder(CreateOrderRequest createOrderRequest);

    RetrieveUserResponseModel retrieveUser(String idType, String idNumber);

    UpdateOrderStatusResponseModel updateOrderStatus(Long transactionId, OrderStatusType status, OrderStatusDescType statusDesc, String remarks);



}
