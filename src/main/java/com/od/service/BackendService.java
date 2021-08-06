package com.od.service;

import com.od.requestModel.SubmitOrdersRequestModel;
import com.od.responseModel.GetCustomerResponseModel;
import com.od.responseModel.GetCustomerRoleResponseModel;
import org.springframework.http.HttpStatus;

public interface BackendService {

    GetCustomerResponseModel retrieveUser(String idType, String idNumber);

    GetCustomerRoleResponseModel getCustomerRole(String customerId);

    HttpStatus submitOrder(SubmitOrdersRequestModel requestModel);


}
