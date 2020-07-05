package com.rabbitmq.consumer.exchange.fanout.hr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

//@Service
public class MarketingConsumer {

    private Logger logger = LoggerFactory.getLogger(MarketingConsumer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.hr.marketing")
    public void listen(String message) {
        Employee emp;
        try {
            emp = objectMapper.readValue(message, Employee.class);
            logger.info("Employee is {}", emp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
