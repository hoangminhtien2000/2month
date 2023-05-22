package com.cassifystudent.model.dto;

import com.cassifystudent.model.ClassRoom;
import lombok.Data;

@Data
public class StudentDto {
    private String names;
    private int age;
    private ClassRoom classRoom;
}
