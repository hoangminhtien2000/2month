package com.rabbitmqlisteners.service;

import com.google.gson.Gson;
import com.rabbitmqlisteners.model.Address;
import com.rabbitmqlisteners.model.dto.DtoInput;
import com.rabbitmqlisteners.repository.AddressRepo;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListner implements MessageListener,SaveAddress {

    @Autowired
    private AddressRepo addressRepo;

        @RabbitListener(queues = "${javainuse.rabbitmq.queue}")
    public void onMessage(Message message) {
            String strDtoInput=new String(message.getBody());
            Gson gson = new Gson();
            DtoInput dtoInput = gson.fromJson(strDtoInput, DtoInput.class);
            saveAddress(dtoInput);
            System.out.println(dtoInput);
    }

    @Override
    public void saveAddress(DtoInput dtoInput) {
        Address address=new Address();
        address.setCountry(dtoInput.getCountry());
        address.setAddress(dtoInput.getAddress());
        addressRepo.save(address);
    }
}
