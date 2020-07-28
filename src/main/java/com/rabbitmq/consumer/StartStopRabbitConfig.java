package com.rabbitmq.consumer;

import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class StartStopRabbitConfig {

    @Autowired
    RabbitListenerEndpointRegistry registry;

    public void stopAll() {
        registry.getListenerContainers().forEach(c -> {
            System.out.println("Stopping container: " + c);
            c.stop();
        });
    }

    public void startAll() {
        registry.getListenerContainers().forEach(c -> {
            System.out.println("Starting container: " + c);
            c.start();
        });
    }

}
