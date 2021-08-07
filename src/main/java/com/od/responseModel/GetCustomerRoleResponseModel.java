package com.od.responseModel;

import com.od.dto.role.RoleDTO;
import com.od.dto.customer.MetaDTO;

import java.util.ArrayList;
import java.util.List;

public class GetCustomerRoleResponseModel {

    private MetaDTO meta;
    private List<RoleDTO> roles = new ArrayList<>();

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}
