package com.rabbitmqhello.controller;
import com.rabbitmqhello.model.Student;
import com.rabbitmqhello.model.dto.DtoInput;
import com.rabbitmqhello.model.dto.DtoOutput;
import com.rabbitmqhello.repository.StudentRepo;
import com.rabbitmqhello.service.RabbitMQSender;
import com.rabbitmqhello.service.CrudStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping()
public class RabbitMQWebController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Autowired
    private CrudStudent crudStudent;


    @Autowired
    private StudentRepo studentRepo;

    @PostMapping()
    public String producer(@RequestBody DtoInput dtoInput) {

        crudStudent.saveStudent(dtoInput);
        DtoOutput dtoOutput=new DtoOutput();
        dtoOutput.setAddress(dtoInput.getAddress());
        dtoOutput.setCountry(dtoInput.getCountry());
//        rabbitMQSender.send(dtoOutput);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

    @GetMapping()
    public Student find(@RequestBody DtoInput dtoInput){
        Student student=studentRepo.findStudentByName(dtoInput.getNames());
        return student;
    }

}
