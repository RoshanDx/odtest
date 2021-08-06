package com.od.enums;

public enum CustomerIdType {

    NEWNRIC("NEWNRIC"),
    PASSPORT("PASSPORT");

    private String idType;

    CustomerIdType(String idType) {
        this.idType = idType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }
}
