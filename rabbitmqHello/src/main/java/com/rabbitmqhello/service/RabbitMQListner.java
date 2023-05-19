package com.rabbitmqhello.service;

import com.google.gson.Gson;
import com.rabbitmqhello.model.dto.DtoInput;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListner implements MessageListener {

        @RabbitListener(queues = "${receiver.service2.queue}")
    public void onMessage(Message message) {
            String strDtoInput=new String(message.getBody());
            System.out.println("Receiver from Service2: "+strDtoInput);

//            String strDtoInput=new String(message.getBody());
//            Gson gson = new Gson();
//            DtoInput dtoInput = gson.fromJson(strDtoInput, DtoInput.class);
//            System.out.println("Receiver from Service2: "+strDtoInput);
    }


}
