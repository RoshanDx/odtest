package com.od.serviceImpl;

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
        String url = "https://avocado.od-tech.my/api/order";

        ResponseEntity<SubmitOrdersRequestModel> response = restTemplate.postForEntity(
                url,
                requestModel,
                SubmitOrdersRequestModel.class);

        return response.getStatusCode();
    }

    public GetCustomerResponseModel retrieveUser(String idType, String idNumber) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<GetCustomerResponseModel> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://avocado.od-tech.my/api/customer";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("idType", idType)
                .queryParam("idNumber", idNumber);

        ResponseEntity<GetCustomerResponseModel> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                GetCustomerResponseModel.class);

//        ResponseEntity<CustomerDTO> response = restTemplate.getForEntity(url , CustomerDTO.class);

        logger.info("CustomerDTO {}", response.getBody());

        return response.getBody();
    }

    public GetCustomerRoleResponseModel getCustomerRole(String customerId) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<GetCustomerRoleResponseModel> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://avocado.od-tech.my/api/customerRole";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
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
