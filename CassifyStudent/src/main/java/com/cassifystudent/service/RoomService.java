package com.cassifystudent.service;

import com.cassifystudent.model.ClassRoom;
import com.cassifystudent.model.Room;
import com.cassifystudent.model.School;
import com.cassifystudent.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class RoomService {

    public Map<String, Room> findAll(School school) {
        Map<String, Room> roomHashMap = new HashMap<>();

        for (ClassRoom classRoom : school.getClassRooms()) {
            roomHashMap.put(classRoom.getClassName(), new Room(classRoom.getClassName(), classRoom.getAddress(), new ArrayList<Student>()));
        }

        for (ClassRoom classRoom : school.getClassRooms()) {
            roomHashMap.put(classRoom.getClassName(), new Room(classRoom.getClassName(), classRoom.getAddress(), new ArrayList<Student>() {{
                for (Student student : school.getStudents()) {
                    if (roomHashMap.containsKey(classRoom.getClassName()) && student.getClassName().equals(classRoom.getClassName())) {
                        add(student);
                    }
                }
            }}));
        }
        return roomHashMap;
    }
}
