package com.cassifystudent.service;

import com.cassifystudent.model.Room;
import com.cassifystudent.model.Student;

import java.util.List;

public interface ClassifyStudent {
    List<Room> findAll(List<Student> students);
}
