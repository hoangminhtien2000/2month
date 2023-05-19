package com.rabbitmqlisteners.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DtoInput {
    private String names;
    private String age;
    private String gender;
    private String country;
    private String address;
//    private String numberCard;
//    private String issuedBy;

}
