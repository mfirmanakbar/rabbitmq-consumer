package com.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class HelloRabbitConsumer {

    @RabbitListener(queues = "testproducer.hello")
    public void listen(String message) {
        System.out.println("consuming " + message);
    }

}
