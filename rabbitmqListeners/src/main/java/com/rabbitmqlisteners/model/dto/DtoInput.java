package com.rabbitmqlisteners.model.dto;

import lombok.Data;

@Data
public class DtoInput {
    private String country;
    private String address;
//    private String numberCard;
//    private String issuedBy;

    @Override
    public String toString() {
        return "DtoInput [Country=" + country + ", Address=" + address + "]";
    }
}
