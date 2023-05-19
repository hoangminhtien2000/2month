package com.rabbitmqhello.config;

import com.rabbitmqhello.service.RabbitMQListner;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${send.service2.queue}")
    String queueName;

    @Value("${javainuse.rabbitmq.exchange}")
    String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }


    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }



    @Value("${receiver.service2.queue}")
    String queueReceiver;

    @Value("${spring.rabbitmq.username}")
    String username;

    @Value("${spring.rabbitmq.password}")
    private String password;


    @Bean
    Queue queueReceiver() {
        return new Queue(queueReceiver, false);
    }

    //create MessageListenerContainer using default connection factory
    @Bean
    MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
//        simpleMessageListenerContainer.setQueues(queue());
        simpleMessageListenerContainer.setQueues(queueReceiver());
        simpleMessageListenerContainer.setMessageListener(new RabbitMQListner());
        return simpleMessageListenerContainer;

    }


//    @Bean
//    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(jsonMessageConverter());
//        return rabbitTemplate;
//    }
}
