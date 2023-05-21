package com.cassifystudent.model;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private List<Student> students;
    private List<ClassRoom> classRooms;
}
