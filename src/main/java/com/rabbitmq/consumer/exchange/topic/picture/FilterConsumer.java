package com.rabbitmq.consumer.exchange.topic.picture;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class FilterConsumer {

    private Logger logger = LoggerFactory.getLogger(FilterConsumer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.picturetopic.filter")
    public void listen(String message) {
        Picture pic;
        try {
            pic = objectMapper.readValue(message, Picture.class);
            logger.info("On Filter : {}", pic);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
