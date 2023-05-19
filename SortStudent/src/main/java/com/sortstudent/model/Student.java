package com.sortstudent.model;

import lombok.Data;

@Data
public class Student {
    private String names;
    private int age;
    private String address;
    private String level;

    public Student(String names, int age, String address, String level) {
        this.names = names;
        this.age = age;
        this.address = address;
        this.level = level;
    }

    public Student() {
    }
}
