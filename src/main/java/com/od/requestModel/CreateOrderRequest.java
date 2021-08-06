package com.od.requestModel;

import com.od.dto.customer.CustomerDTO;
import com.od.dto.order.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class CreateOrderRequest {

    private CustomerDTO customer;
    private List<OrderDTO> orders = new ArrayList<>();

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}
