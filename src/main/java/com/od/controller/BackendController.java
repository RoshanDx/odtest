package com.od.controller;

import com.od.dto.customer.MetaDTO;
import com.od.requestModel.SubmitOrdersRequestModel;
import com.od.responseModel.GetCustomerResponseModel;
import com.od.responseModel.GetCustomerRoleResponseModel;
import com.od.responseModel.SubmitOrderResponseModel;
import com.od.service.BackendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
public class BackendController {

    @Autowired
    BackendService backendService;

    @RequestMapping(path= "/getCustomer", method = RequestMethod.GET)
    public ResponseEntity<GetCustomerResponseModel> getUser(@RequestParam String idType, @RequestParam String idNumber)
    {
        GetCustomerResponseModel responseModel = backendService.retrieveUser(idType, idNumber);
//        UserResponseModel returnValue = new ModelMapper().map(userDto, UserResponseModel.class);
        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @RequestMapping(path= "/customerRole", method = RequestMethod.GET)
    public ResponseEntity<GetCustomerRoleResponseModel> getCustomerRole(@RequestParam String customerId)
    {
        GetCustomerRoleResponseModel responseModel = backendService.getCustomerRole(customerId);
//        UserResponseModel returnValue = new ModelMapper().map(userDto, UserResponseModel.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @RequestMapping(path= "/submitOrder", method = RequestMethod.POST)
    public ResponseEntity<SubmitOrderResponseModel> getCustomerRole(@RequestBody SubmitOrdersRequestModel requestModel)
    {
        SubmitOrderResponseModel responseModel = new SubmitOrderResponseModel();
        HttpStatus statusCode = backendService.submitOrder(requestModel);
        if (statusCode.equals(HttpStatus.OK)) {
            responseModel.setMeta(new MetaDTO(HttpStatus.OK.value()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

}
