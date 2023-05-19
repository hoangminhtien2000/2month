package com.sortstudent.controller;

import com.sortstudent.model.Student;
import com.sortstudent.service.IStudentDecrease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class StudentController {
    @Autowired
    private IStudentDecrease iStudentDecrease;

    @GetMapping()
    public List<Student> studentDecrease(@RequestBody List<Student> students){
        iStudentDecrease.studentDecrease(students);
        return students;
    }
}
