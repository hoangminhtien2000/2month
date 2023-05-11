package com.rabbitmqhello.controller;
import com.rabbitmqhello.model.dto.DtoInput;
import com.rabbitmqhello.model.dto.DtoOutput;
import com.rabbitmqhello.service.RabbitMQSender;
import com.rabbitmqhello.service.SaveStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping()
public class RabbitMQWebController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Autowired
    private SaveStudent saveStudent;

    @PostMapping()
    public String producer(@RequestBody DtoInput dtoInput) {

        saveStudent.saveStudent(dtoInput);
        DtoOutput dtoOutput=new DtoOutput();
        dtoOutput.setAddress(dtoInput.getAddress());
        dtoOutput.setCountry(dtoInput.getCountry());
        rabbitMQSender.send(dtoOutput);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

}
