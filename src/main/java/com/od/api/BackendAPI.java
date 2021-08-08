package com.od.api;

public enum BackendAPI {

    SUBMIT_ORDERS("https://avocado.od-tech.my/api/order"),
    GET_CUSTOMER("https://avocado.od-tech.my/api/customer"),
    GET_CUSTOMER_ROLE("https://avocado.od-tech.my/api/customerRole");

    private String getAPI;

    BackendAPI(String getAPI) {
        this.getAPI = getAPI;
    }

    public String getGetAPI() {
        return getAPI;
    }

    public void setGetAPI(String getAPI) {
        this.getAPI = getAPI;
    }
}
