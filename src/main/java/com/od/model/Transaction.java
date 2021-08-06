package com.od.model;

import com.od.enums.OrderStatusDescType;
import com.od.enums.OrderStatusType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long trxRefId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatusType status;
//    private String status;

//    @Column(name = "statusDesc")
//    private String statusDesc;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusDesc")
    private OrderStatusDescType statusDesc;

    @Column(name = "remarks")
    private String remarks;
    @Column(name = "created")
    private Date created;
    @Column(name = "lastUpdated")
    private Date lastUpdated;

    @OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "transactions_orders_fk", referencedColumnName = "trxRefId", foreignKey = @ForeignKey( name = "fk_orders_transactions_id"))
    private List<Order> orders = new ArrayList<>();

    public long getTrxRefId() {
        return trxRefId;
    }

    public void setTrxRefId(long trxRefId) {
        this.trxRefId = trxRefId;
    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

//    public String getStatusDesc() {
//        return statusDesc;
//    }
//
//    public void setStatusDesc(String statusDesc) {
//        this.statusDesc = statusDesc;
//    }

    public OrderStatusDescType getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(OrderStatusDescType statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
