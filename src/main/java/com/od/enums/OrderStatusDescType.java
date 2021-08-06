package com.od.enums;

public enum OrderStatusDescType {
    SUBMITTED("Submitted"),
    INPROGRESS("In Progress"),
    CANCELLED("Cancelled"),
    EXCEPTION("Unsuccessful"),
    COMPLETED("Completed");

    private String orderStatusDesc;

    OrderStatusDescType(String orderStatusDesc) {
        this.orderStatusDesc = orderStatusDesc;
    }

    public String getOrderStatusDesc() {
        return orderStatusDesc;
    }

    public void setOrderStatusDesc(String orderStatusDesc) {
        this.orderStatusDesc = orderStatusDesc;
    }
}
