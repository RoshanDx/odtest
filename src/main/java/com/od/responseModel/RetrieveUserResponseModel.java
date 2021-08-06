package com.od.responseModel;

import com.od.dto.RoleDTO;
import com.od.dto.customer.CustomerDTO;
import com.od.dto.customer.MetaDTO;

import java.util.List;

public class RetrieveUserResponseModel {
    private MetaDTO meta;
    private CustomerDTO customer;
    private List <RoleDTO> roles;

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

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}
