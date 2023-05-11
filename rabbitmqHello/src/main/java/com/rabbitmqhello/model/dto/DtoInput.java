package com.rabbitmqhello.model.dto;

import lombok.Data;

@Data
public class DtoInput {
    private String names;
    private String age;
    private String gender;
    private String country;
    private String address;
//    private String numberCard;
//    private String issuedBy;

    @Override
    public String toString() {
        return "DtoInput [Name=" + names + ", Age=" + age + ", Gender=" + gender + ", Country=" + country + ", Address=" + address + "]";
    }

}
