package com.od.controller;

import com.od.dto.TransactionDTO;
import com.od.enums.OrderStatusType;
import com.od.requestModel.CreateOrderRequest;
import com.od.requestModel.SubmitOrdersRequestModel;
import com.od.responseModel.CreateOrderResponseModel;
import com.od.responseModel.GetCustomerRoleResponseModel;
import com.od.responseModel.RetrieveUserResponseModel;
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
    public ResponseEntity<CreateOrderResponseModel> createOrder(@RequestBody CreateOrderRequest createOrderRequest)
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
    public ResponseEntity<TransactionDTO> retrieveUser(@PathVariable Long trxRefId, @RequestParam OrderStatusType status, @RequestParam String remarks)
    {
        TransactionDTO responseModel = middlewareService.updateOrderStatus(trxRefId, status, remarks);
        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }



}
