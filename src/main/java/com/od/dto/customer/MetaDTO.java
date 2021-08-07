package com.od.dto.customer;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class MetaDTO {

    private long code;
    private long recordCount;

    public MetaDTO(long code) {
        this.code = code;
    }

    public MetaDTO(long code, long recordCount) {
        this.code = code;
        this.recordCount = recordCount;
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

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }
}
