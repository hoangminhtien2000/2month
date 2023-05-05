package com.aplicationservices.conmon;

import org.springframework.stereotype.Service;

@Service
public class ValidateInput {

    public final String names ="^[a-zA-Z0-9 ]+$";
    public final String age ="\\b([1-9][0-9]?|1[0-4][0-9]|150)\\b";
    public final String gender ="^(male|female)$";
    public final String country ="[a-zA-Z0-9 ]{1,10}";
    public final String address ="[a-zA-Z0-9 ]{1,50}";
    public final String numberCard ="\\d{12}";
    public final String issuedBy ="[a-zA-Z0-9 ]{1,20}";
    public final String messageOutput ="^(?!.*(?:Error Country|Error Address|Error NumberCard|Error IssuedBy)).*$";
    public final String statusCode ="^(?!.*(?:200 OK)).*$";
    public final String checkMessage ="^(?!.*(?:Error Name|Error Age|Error Gender|Error Country|Error Address|Error NumberCard|Error IssuedBy)).*$";
    public final String errorName ="Error Name, ";
    public final String errorAge ="Error Age, ";
    public final String errorGender ="Error Gender, ";
    public final String errorCountry ="Error Country, ";
    public final String errorAddress ="Error Address, ";
    public final String errorNumberCard ="Error NumberCard, ";
    public final String errorIssuedBy ="Error IssuedBy, ";
    public final String successStudent ="Save Student Success| ";
    public final String successAddress ="Save Address Success| ";
    public final String successIDCard ="Save IDCard Success| ";

}
