package com.aplicationservices.conmon;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String queueName, Object message) {
        amqpTemplate.convertAndSend(queueName, message);
        System.out.println("Message sent to the RabbitMQ Successfully");
    }
}
