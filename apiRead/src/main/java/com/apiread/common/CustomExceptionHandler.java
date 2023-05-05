package com.apiread.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;


@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleException(FileNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setErrorCode("Không tìm thấy file");
//        errorResponse.setErrorMessage(ex.getMessage());
        errorResponse.setErrorMessage("Không tìm thấy file");
        return errorResponse;
    }
}
