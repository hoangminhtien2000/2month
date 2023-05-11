package com.service1.service;


import com.service1.model.dto.DtoInput;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface SendAddress {
     String sendAddress(DtoInput dtoInput) throws IOException, TimeoutException;
}
