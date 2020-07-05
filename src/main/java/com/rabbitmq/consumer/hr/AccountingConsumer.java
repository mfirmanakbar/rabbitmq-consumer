package com.rabbitmq.consumer.hr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class AccountingConsumer {

    private Logger logger = LoggerFactory.getLogger(AccountingConsumer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.hr.accounting")
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
