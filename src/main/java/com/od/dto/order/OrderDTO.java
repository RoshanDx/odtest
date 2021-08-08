package com.od.dto.order;

import com.od.enums.OrderCodeType;
import com.od.model.Transaction;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
