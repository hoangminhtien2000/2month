package com.service1;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//public class Runner implements CommandLineRunner {
public class Runner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("my-exchange", "my-routing-key", message);
    }

    public Runner(Receiver receiver,  RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Sending message...");
//        rabbitTemplate.convertAndSend(Service1Application.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//    }

}