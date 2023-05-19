package com.rabbitmqlisteners.service;

import com.rabbitmqlisteners.model.dto.DtoInput;
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

    public void send(String message) {
        rabbitTemplate.convertAndSend(exchange, routingkey, message);
        System.out.println("Send to Service1 : " + message);

    }

//    public void send(DtoInput dtoInput) {
//        rabbitTemplate.convertAndSend(exchange, routingkey, dtoInput);
//        System.out.println("Send to Service2 = " + dtoInput);
//
//    }
}
