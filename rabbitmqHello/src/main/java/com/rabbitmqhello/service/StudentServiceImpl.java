package com.rabbitmqhello.service;

import com.rabbitmqhello.model.Student;
import com.rabbitmqhello.model.dto.DtoInput;
import com.rabbitmqhello.model.dto.DtoOutput;
import com.rabbitmqhello.repository.StudentRepo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements CrudStudent {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    @Transactional
//    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void saveSendStudent(DtoInput dtoInput)  {
        Student student=new Student();
        student.setNames(dtoInput.getNames());
        student.setAge(Integer.parseInt(dtoInput.getAge()));
        student.setGender(dtoInput.getGender());
//        studentRepo.save(student);
        if (dtoInput.getNames().equals("Tien23")) {
            throw new RuntimeException("thowing exception to test transaction rollback");
        }
        else {
            DtoOutput dtoOutput=new DtoOutput();
            dtoOutput.setAddress(dtoInput.getAddress());
            dtoOutput.setCountry(dtoInput.getCountry());
            rabbitMQSender.send(dtoOutput);
        }
    }

    @Override
    public void deleteStudent(DtoInput dtoInput) {
        Student student= studentRepo.findStudentByName(dtoInput.getNames());
        studentRepo.deleteById(student.getId());

    }
}