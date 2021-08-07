package com.od.service;

import com.od.dto.transaction.TransactionDTO;
import com.od.enums.OrderStatusDescType;
import com.od.enums.OrderStatusType;
import com.od.model.Transaction;
import com.od.model.TransactionPage;
import com.od.requestModel.CreateOrderRequest;
import com.od.responseModel.CreateOrderResponseModel;
import com.od.responseModel.RetrieveUserResponseModel;
import com.od.responseModel.SearchOrderResponseModel;
import com.od.responseModel.UpdateOrderStatusResponseModel;
import org.springframework.data.domain.Page;

public interface MiddlewareService {

    CreateOrderResponseModel createOrder(CreateOrderRequest createOrderRequest);

    RetrieveUserResponseModel retrieveUser(String idType, String idNumber);

    UpdateOrderStatusResponseModel updateOrderStatus(
            Long transactionId,
            OrderStatusType status,
            OrderStatusDescType statusDesc,
            String remarks);

    SearchOrderResponseModel getOrders (TransactionPage transactionPage);

}
