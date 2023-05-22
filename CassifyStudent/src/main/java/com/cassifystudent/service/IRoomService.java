package com.cassifystudent.service;

import com.cassifystudent.model.Room;
import com.cassifystudent.model.dto.StudentDto;

import java.util.List;

public interface IRoomService {
    List<Room> findAll(List<StudentDto> studentDtos);
}
