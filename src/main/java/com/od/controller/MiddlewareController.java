package com.od.controller;

import com.od.enums.OrderStatusDescType;
import com.od.enums.OrderStatusType;
import com.od.requestModel.SearchOrderRequestModel;
import com.od.requestModel.CreateOrderRequestModel;
import com.od.responseModel.CreateOrderResponseModel;
import com.od.responseModel.RetrieveUserResponseModel;
import com.od.responseModel.SearchOrderResponseModel;
import com.od.responseModel.UpdateOrderStatusResponseModel;
import com.od.service.MiddlewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
public class MiddlewareController {

    @Autowired
    MiddlewareService middlewareService;

    @RequestMapping(path= "/order", method = RequestMethod.POST)
    public ResponseEntity<CreateOrderResponseModel> createOrder(@RequestBody CreateOrderRequestModel createOrderRequest)
    {
        CreateOrderResponseModel responseModel = middlewareService.createOrder(createOrderRequest);
        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @RequestMapping(path= "/user", method = RequestMethod.GET)
    public ResponseEntity<RetrieveUserResponseModel> retrieveUser(@RequestParam String idType, @RequestParam String idNumber)
    {
        RetrieveUserResponseModel responseModel = middlewareService.retrieveUser(idType, idNumber);
        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @RequestMapping(path= "/order/{trxRefId}/status", method = RequestMethod.PUT)
    public ResponseEntity<UpdateOrderStatusResponseModel> retrieveUser(@PathVariable Long trxRefId, @RequestParam OrderStatusType status,
                                                                       @RequestParam OrderStatusDescType statusDesc, @RequestParam String remarks)
    {
        UpdateOrderStatusResponseModel responseModel = middlewareService.updateOrderStatus(trxRefId, status, statusDesc, remarks);
        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @RequestMapping(path= "/searchOrder", method = RequestMethod.POST)
    public ResponseEntity<SearchOrderResponseModel> searchOrders(@RequestBody SearchOrderRequestModel transactionPage) {
        return new ResponseEntity<>(middlewareService.getOrders(transactionPage), HttpStatus.OK);
    }


}
