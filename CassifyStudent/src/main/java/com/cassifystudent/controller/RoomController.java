package com.cassifystudent.controller;

import com.cassifystudent.model.Room;
import com.cassifystudent.model.dto.StudentDto;
import com.cassifystudent.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classify")
public class RoomController {
    @Autowired
    private IRoomService IRoomService;

    @GetMapping()
    public List<Room> findAll(@RequestBody List<StudentDto> studentDtos) {
        return IRoomService.findAll(studentDtos);
    }
}
