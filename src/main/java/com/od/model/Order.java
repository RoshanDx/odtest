package com.od.model;

import com.od.enums.OrderCodeType;
import com.od.enums.OrderStatusType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "code")
    private OrderCodeType code;

    @Column(name = "quantity")
    private double quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
