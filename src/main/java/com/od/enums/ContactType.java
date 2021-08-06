package com.od.enums;

public enum ContactType {

    PHONE("PHONE"),
    EMAIL("EMAIL");

    private String type;

    ContactType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
