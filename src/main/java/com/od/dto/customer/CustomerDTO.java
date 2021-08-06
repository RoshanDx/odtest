package com.od.dto.customer;

import java.util.ArrayList;

public class CustomerDTO {

    private String id;
    private IdentificationDTO identification;
    private DetailsDTO details;
    private ArrayList<ContactDTO> contact = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IdentificationDTO getIdentification() {
        return identification;
    }

    public void setIdentification(IdentificationDTO identification) {
        this.identification = identification;
    }

    public DetailsDTO getDetails() {
        return details;
    }

    public void setDetails(DetailsDTO details) {
        this.details = details;
    }

    public ArrayList<ContactDTO> getContact() {
        return contact;
    }

    public void setContact(ArrayList<ContactDTO> contact) {
        this.contact = contact;
    }
}
