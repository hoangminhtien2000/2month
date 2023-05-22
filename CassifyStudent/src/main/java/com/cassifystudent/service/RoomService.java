package com.cassifystudent.service;

import com.cassifystudent.model.Room;
import com.cassifystudent.model.Student;
import com.cassifystudent.model.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomService implements IRoomService {

    @Override
    public List<Room> findAll(List<StudentDto> studentDtos) {
        Map<String, Room> roomsByClassName = new HashMap<>();
        // Chia các đối tượng StudentDto thành các nhóm dựa trên ClassName
        for (StudentDto studentDto : studentDtos) {
            String className = studentDto.getClassRoom().getClassName();
            Student student=new Student();
            student.setNames(studentDto.getNames());
            student.setAge(studentDto.getAge());
            if (roomsByClassName.containsKey(className)) {
                roomsByClassName.get(className).getStudents().add(student);
            } else {
                List<Student> studentList = new ArrayList<>();
                studentList.add(student);
                roomsByClassName.put(className, new Room(studentDto.getClassRoom().getClassName(), studentDto.getClassRoom().getAddress(), studentList));
            }
        }
        return new ArrayList<>(roomsByClassName.values());
    }

}
