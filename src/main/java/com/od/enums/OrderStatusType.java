package com.od.enums;

    public enum OrderStatusType {
        SUBMITTED("SUBMITTED"),
        INPROGRESS("INPROGRESS"),
        CANCELLED("CANCELLED"),
        EXCEPTION("EXCEPTION"),
        COMPLETED("COMPLETED");

        private String orderStatus;

        OrderStatusType(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
    }


