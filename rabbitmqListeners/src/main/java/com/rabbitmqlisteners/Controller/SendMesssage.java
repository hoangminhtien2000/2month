package com.rabbitmqlisteners.Controller;

import com.rabbitmqlisteners.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class SendMesssage {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping()
    public String SenderService1() {
        rabbitMQSender.send("Service2 Success");
        return "Service2 Success";
    }

}
