package com.od.requestModel;

import com.od.dto.customer.CustomerDTO;
import com.od.enums.OrderStatusType;

import java.util.Date;

public class SearchOrderRequestModel {

    private CustomerDTO customer;
    private Date startDate;
    private Date endDate;
    private OrderStatusType statusCode;
    private long startRecord;
    private long recordLimit;

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public OrderStatusType getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(OrderStatusType statusCode) {
        this.statusCode = statusCode;
    }

    public long getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(long startRecord) {
        this.startRecord = startRecord;
    }

    public long getRecordLimit() {
        return recordLimit;
    }

    public void setRecordLimit(long recordLimit) {
        this.recordLimit = recordLimit;
    }
}
