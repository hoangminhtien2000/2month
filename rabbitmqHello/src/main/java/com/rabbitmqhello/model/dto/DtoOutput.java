package com.rabbitmqhello.model.dto;

import lombok.Data;

@Data
public class DtoOutput {
    private String country;
    private String address;
//    private String numberCard;
//    private String issuedBy;

    @Override
    public String toString() {
        return "DtoOutput [Country=" + country + ", Address=" + address + "]";
    }
}
