package com.od.model;

import com.od.enums.OrderCodeType;
import com.od.enums.OrderStatusType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @Column(name = "code")
//    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "code")
    private OrderCodeType code;

    @Column(name = "quantity")
    private double quantity;

//    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @JoinColumn(
//            name = "transaction_id",
//            nullable = false,
//            foreignKey = @ForeignKey(
//                    name = "fk_orders_transactions_id"
//            )
//    )
//    private Transaction transaction;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }

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
