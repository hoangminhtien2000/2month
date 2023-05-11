package com.aplicationservices.service;

import com.aplicationservices.model.dto.DtoInput;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface SendAddress {
     String sendAddress(DtoInput dtoInput) throws IOException, TimeoutException;
}
