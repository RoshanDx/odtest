package com.od.dto.customer;

import com.od.enums.CustomerIdType;

public class IdentificationDTO {

    private CustomerIdType idType;
    private String idNumber;

    public CustomerIdType getIdType() {
        return idType;
    }

    public void setIdType(CustomerIdType idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
