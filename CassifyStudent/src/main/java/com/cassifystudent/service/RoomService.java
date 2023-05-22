package com.cassifystudent.service;

import com.cassifystudent.model.Room;
import com.cassifystudent.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomService implements ClassifyStudent{

    @Override
    public List<Room> findAll(List<Student> students) {
        Map<String, Room> roomsByClassName = new HashMap<>();
        // Chia các đối tượng Student thành các nhóm dựa trên ClassName
        for (Student student : students) {
            String className = student.getClassRoom().getClassName();
            if (roomsByClassName.containsKey(className)) {
                roomsByClassName.get(className).getStudents().add(student);
            } else {
                List<Student> studentList = new ArrayList<>();
                studentList.add(student);
                roomsByClassName.put(className, new Room(student.getClassRoom().getClassName(), student.getClassRoom().getAddress(), studentList));
            }
        }
        return new ArrayList<>(roomsByClassName.values());
    }

}
