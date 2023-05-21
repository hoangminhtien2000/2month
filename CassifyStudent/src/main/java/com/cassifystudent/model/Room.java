package com.cassifystudent.model;

import lombok.Data;

import java.util.List;

@Data
public class Room {
    private String className;
    private String address;
    List<Student> students;

    public Room(String className, String address, List<Student> students) {
        this.className = className;
        this.address = address;
        this.students = students;
    }
}
