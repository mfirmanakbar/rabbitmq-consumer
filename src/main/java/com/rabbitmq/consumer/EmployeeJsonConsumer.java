package com.rabbitmq.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class EmployeeJsonConsumer {

    private Logger logger = LoggerFactory.getLogger(EmployeeJsonConsumer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "test.employee")
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
