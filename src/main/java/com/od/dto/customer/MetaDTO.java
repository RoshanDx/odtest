package com.od.dto.customer;

public class MetaDTO {
    private long code;

    public MetaDTO(long code) {
        this.code = code;
    }

    public MetaDTO() {
        super();
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }
}
