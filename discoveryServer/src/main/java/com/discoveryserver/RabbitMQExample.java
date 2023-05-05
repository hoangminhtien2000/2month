//package com.discoveryserver;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//import com.rabbitmq.client.DeliverCallback;
//
//public class RabbitMQExample {
//    private final static String QUEUE_NAME = "hello";
//
//    public static void main(String[] args) throws Exception {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        try (Connection connection = factory.newConnection();
//             Channel channel = connection.createChannel()) {
//            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//            String message = "Hello World!";
//            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
//            System.out.println(" [x] Sent '" + message + "'");
//            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//                String receivedMessage = new String(delivery.getBody(), "UTF-8");
//                System.out.println(" [x] Received '" + receivedMessage + "'");
//            };
//            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
//        }
//    }
//}

