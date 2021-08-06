package com.od.requestModel;

import com.od.dto.order.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class SubmitOrdersRequestModel {

    private String customerId;
    private List<OrderDTO> order = new ArrayList<>();

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<OrderDTO> getOrder() {
        return order;
    }

    public void setOrders(List<OrderDTO> order) {
        this.order = order;
    }
}
