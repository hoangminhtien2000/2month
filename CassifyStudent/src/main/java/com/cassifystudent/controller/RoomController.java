package com.cassifystudent.controller;

import com.cassifystudent.model.Room;
import com.cassifystudent.model.School;
import com.cassifystudent.service.ClassifyStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/classify")
public class RoomController {
    @Autowired
    private ClassifyStudent classifyStudent;

    @GetMapping()
    public Map<String, Room> findAll(@RequestBody School school) {
        return classifyStudent.findAll(school);
    }
}
