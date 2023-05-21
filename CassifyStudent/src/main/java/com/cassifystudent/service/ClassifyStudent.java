package com.cassifystudent.service;

import com.cassifystudent.model.Room;
import com.cassifystudent.model.School;

import java.util.Map;

public interface ClassifyStudent {
    Map<String, Room> findAll(School school);
}
