package com.od.dto;

import com.od.dto.order.OrderDTO;
import com.od.enums.OrderStatusDescType;
import com.od.enums.OrderStatusType;
import com.od.model.Order;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDTO {

    private long trxRefId;
//    private String status;
//    private String statusDesc;
    private OrderStatusType status;
    private OrderStatusDescType statusDesc;

    private String remarks;
    private Date created;
    private Date lastUpdated;
    private List<OrderDTO> orders = new ArrayList<>();

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
//
//    public String getStatusDesc() {
//        return statusDesc;
//    }
//
//    public void setStatusDesc(String statusDesc) {
//        this.statusDesc = statusDesc;
//    }


    public OrderStatusType getStatus() {
        return status;
    }

    public void setStatus(OrderStatusType status) {
        this.status = status;
    }

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

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}
