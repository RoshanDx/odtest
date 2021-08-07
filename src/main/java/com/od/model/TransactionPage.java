package com.od.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.od.enums.OrderStatusType;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Optional;

public class TransactionPage {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate = new Date();
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate = new Date();
    private OrderStatusType statusCode;
    private int startRecord = 1;
    private int recordLimit = 10;

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

    public int getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(int startRecord) {
        this.startRecord = startRecord;
    }

    public int getRecordLimit() {
        return recordLimit;
    }

    public void setRecordLimit(int recordLimit) {
        this.recordLimit = recordLimit;
    }

}
