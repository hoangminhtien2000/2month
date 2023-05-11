package com.rabbitmqhello.service;

import com.rabbitmqhello.model.Student;
import com.rabbitmqhello.model.dto.DtoInput;
import com.rabbitmqhello.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements SaveStudent {

    @Autowired
    private StudentRepo studentRepo;


    @Override
    public void saveStudent(DtoInput dtoInput) {
        Student student=new Student();
        student.setName(dtoInput.getName());
        student.setAge(Integer.parseInt(dtoInput.getAge()));
        student.setGender(dtoInput.getGender());
        studentRepo.save(student);
    }
}