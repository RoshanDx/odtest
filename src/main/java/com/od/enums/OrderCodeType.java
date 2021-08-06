package com.od.enums;

public enum OrderCodeType {
    A1("A1"),
    A2("A2"),
    A3("A3");

    private String orderCode;

    OrderCodeType(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
