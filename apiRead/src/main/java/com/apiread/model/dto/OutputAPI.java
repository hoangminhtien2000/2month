package com.apiread.model.dto;

import lombok.Data;

@Data
public class OutputAPI {
    private String fileName="result.xlsx";
    private String content;
    private int totalRecord=0;
    private int successRecord=0;
}
