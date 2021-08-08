package com.od.service;

import com.od.enums.OrderStatusDescType;
import com.od.enums.OrderStatusType;
import com.od.requestModel.SearchOrderRequestModel;
import com.od.requestModel.CreateOrderRequestModel;
import com.od.responseModel.CreateOrderResponseModel;
import com.od.responseModel.RetrieveUserResponseModel;
import com.od.responseModel.SearchOrderResponseModel;
import com.od.responseModel.UpdateOrderStatusResponseModel;

public interface MiddlewareService {

    CreateOrderResponseModel createOrder(CreateOrderRequestModel createOrderRequest);

    RetrieveUserResponseModel retrieveUser(String idType, String idNumber);

    UpdateOrderStatusResponseModel updateOrderStatus(
            Long transactionId,
            OrderStatusType status,
            OrderStatusDescType statusDesc,
            String remarks);

    SearchOrderResponseModel getOrders (SearchOrderRequestModel transactionPage);

}
