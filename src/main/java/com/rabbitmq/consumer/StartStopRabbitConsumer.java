package com.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class StartStopRabbitConsumer {

    @Autowired
    StartStopRabbitConfig startStopRabbitConfig;

    Logger logger = LoggerFactory.getLogger(StartStopRabbitConsumer.class);

    @RabbitListener(queues = "q.dummy")
    public void listen(String message) {
        boolean isTurnOn = false;
        if (isTurnOn) {
            startStopRabbitConfig.startAll();
            logger.info("Consuming-AND-RUN-" + message);
        } else {
            startStopRabbitConfig.stopAll();
        }
    }

}
