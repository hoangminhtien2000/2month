package com.cassifystudent.controller;

import com.cassifystudent.model.Room;
import com.cassifystudent.model.Student;
import com.cassifystudent.service.ClassifyStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classify")
public class RoomController {
    @Autowired
    private ClassifyStudent classifyStudent;

    @GetMapping()
    public List<Room> findAll(@RequestBody List<Student> students) {
        return classifyStudent.findAll(students);
    }
}
