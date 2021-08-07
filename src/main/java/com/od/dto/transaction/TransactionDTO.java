package com.od.dto.transaction;

import com.od.dto.order.OrderDTO;
import com.od.enums.OrderStatusDescType;
import com.od.enums.OrderStatusType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDTO {

    private long trxRefId;
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
