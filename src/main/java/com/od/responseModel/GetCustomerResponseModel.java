package com.od.responseModel;

import com.od.dto.customer.CustomerDTO;
import com.od.dto.customer.MetaDTO;

public class GetCustomerResponseModel {

    private MetaDTO meta;
    private CustomerDTO customer;

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
