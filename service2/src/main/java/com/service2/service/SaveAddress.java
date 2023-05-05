package com.service2.service;


import com.service2.model.Address;
import com.service2.model.dto.DtoInput;
import com.service2.model.dto.DtoOutput;

public interface SaveAddress {
     String saveAddress(DtoInput dtoInput);
}
