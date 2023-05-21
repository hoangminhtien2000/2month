package com.cassifystudent.model;

import lombok.Data;


@Data
public class ClassRoom {
    private String className;
    private String address;

    public ClassRoom(String className, String address) {
        this.className = className;
        this.address = address;
    }

}
