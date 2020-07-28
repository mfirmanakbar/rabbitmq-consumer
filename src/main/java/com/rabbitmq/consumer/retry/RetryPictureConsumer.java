package com.rabbitmq.consumer.retry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class RetryPictureConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger log = LoggerFactory.getLogger(RetryPictureConsumer.class);

    @RabbitListener(queues = "q.spring-direct.image.work")
    public void listenImage(String message) throws JsonParseException, JsonMappingException, IOException {
        Picture picture = objectMapper.readValue(message, Picture.class);
        log.info("Consuming image: {}", picture.getName());

        if (picture.getSize() > 9000) {
            throw new IOException("Image " + picture.getName() + " size too large : " + picture.getSize());
        }

        log.info("Creating thumbnail & publishing image : {}", picture.getName());
    }

    @RabbitListener(queues = "q.spring-direct.vector.work")
    public void listenVector(String message) throws JsonParseException, JsonMappingException, IOException {
        Picture picture = objectMapper.readValue(message, Picture.class);
        log.info("Consuming vector: {}", picture.getName());
        log.info("Creating to image, Creating thumbnail & publishing image : {}", picture.getName());
    }

}
