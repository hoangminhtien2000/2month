package com.rabbitmqhello.controller;
import com.rabbitmqhello.model.Student;
import com.rabbitmqhello.model.dto.DtoInput;
import com.rabbitmqhello.repository.StudentRepo;
import com.rabbitmqhello.service.CrudStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping()
public class RabbitMQWebController {

    @Autowired
    private CrudStudent crudStudent;


    @Autowired
    private StudentRepo studentRepo;

    @PostMapping()
    public String producer(@RequestBody DtoInput dtoInput) {
        crudStudent.saveSendStudent(dtoInput);
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

    @GetMapping()
    public Student find(@RequestBody DtoInput dtoInput){
        Student student=studentRepo.findStudentByName(dtoInput.getNames());
        return student;
    }

}
