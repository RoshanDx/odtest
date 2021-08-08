package com.od.serviceImpl;

import com.od.api.BackendAPI;
import com.od.requestModel.SubmitOrdersRequestModel;
import com.od.responseModel.GetCustomerResponseModel;
import com.od.responseModel.GetCustomerRoleResponseModel;
import com.od.service.BackendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class BackendServiceImpl implements BackendService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public HttpStatus submitOrder(SubmitOrdersRequestModel requestModel) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SubmitOrdersRequestModel> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<SubmitOrdersRequestModel> response = restTemplate.postForEntity(
                BackendAPI.SUBMIT_ORDERS.getGetAPI(),
                requestModel,
                SubmitOrdersRequestModel.class);

        return response.getStatusCode();
    }

    public GetCustomerResponseModel retrieveUser(String idType, String idNumber) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<GetCustomerResponseModel> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BackendAPI.GET_CUSTOMER.getGetAPI())
                .queryParam("idType", idType)
                .queryParam("idNumber", idNumber);

        ResponseEntity<GetCustomerResponseModel> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                GetCustomerResponseModel.class);

        logger.info("CustomerDTO {}", response.getBody());

        return response.getBody();
    }

    public GetCustomerRoleResponseModel getCustomerRole(String customerId) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<GetCustomerRoleResponseModel> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BackendAPI.GET_CUSTOMER_ROLE.getGetAPI())
                .queryParam("customerId", customerId);

        ResponseEntity<GetCustomerRoleResponseModel> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                GetCustomerRoleResponseModel.class);

        logger.info("RoleDTO {}", response.getBody());

        return response.getBody();
    }

}
