package com.rabbitmqhello.service;

import com.rabbitmqhello.model.dto.DtoInput;
import com.rabbitmqhello.model.dto.DtoOutput;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;

//    public void send(DtoOutput dtoOutput) {
//        rabbitTemplate.convertAndSend(exchange, routingkey, dtoOutput);
//        System.out.println("Send to Service2 = " + dtoOutput);
//
//    }

    public void send(DtoInput dtoInput) {
        rabbitTemplate.convertAndSend(exchange, routingkey, dtoInput);
        System.out.println("Send to Service2 : " + dtoInput);

    }

}
