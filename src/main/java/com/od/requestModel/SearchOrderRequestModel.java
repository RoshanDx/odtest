package com.od.requestModel;

import com.od.dto.customer.CustomerDTO;

import java.util.Date;

public class SearchOrderRequestModel {

    private CustomerDTO customer;
    private Date startDate;
    private Date endDate;
    private String statusCode;
    private Long startRecord;
    private Long recordLimit;

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

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Long getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(Long startRecord) {
        this.startRecord = startRecord;
    }

    public Long getRecordLimit() {
        return recordLimit;
    }

    public void setRecordLimit(Long recordLimit) {
        this.recordLimit = recordLimit;
    }
}
