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

    @Autowired
    private RabbitMQSender rabbitMQSender;

        @RabbitListener(queues = "${receiver.service1.queue}")
    public void onMessage(Message message) {
            String strDtoInput=new String(message.getBody());
            Gson gson = new Gson();
            DtoInput dtoInput = gson.fromJson(strDtoInput, DtoInput.class);
//            saveAddress(dtoInput);
            System.out.println("Receiver from Service1: "+dtoInput);
//            rabbitMQSender.send(" Send to Service1 Success");

    }

    @Override
    public void saveAddress(DtoInput dtoInput) {
        Address address=new Address();
        address.setCountry(dtoInput.getCountry());
        address.setAddress(dtoInput.getAddress());
        addressRepo.save(address);
    }
}
