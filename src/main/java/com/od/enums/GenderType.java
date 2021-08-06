package com.od.enums;

public enum GenderType {
    MALE("MALE"),
    FEMALE("FEMALE");

    private String gender;

    GenderType(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
