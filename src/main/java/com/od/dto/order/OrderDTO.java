package com.od.dto.order;

import com.od.enums.OrderCodeType;

public class OrderDTO {

    private OrderCodeType code;
    private double quantity;

    public OrderCodeType getCode() {
        return code;
    }

    public void setCode(OrderCodeType code) {
        this.code = code;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

}
