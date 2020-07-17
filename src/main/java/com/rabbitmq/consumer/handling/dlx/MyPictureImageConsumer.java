package com.rabbitmq.consumer.handling.dlx;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MyPictureImageConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Logger logger = LoggerFactory.getLogger(MyPictureImageConsumer.class);

    @RabbitListener(queues = "q.mypicture.image")
    public void listen(String message) throws JsonParseException, JsonMappingException, IOException {
        Picture pic = objectMapper.readValue(message, Picture.class);

        if (pic.getSize() > 9000) {

            // don't using this throw IllegalArgumentException,
            // it makes the Infinite Loop forever
            //throw new IllegalArgumentException("Picture size too large : " + pic);

            // this throw to reject the Queue,
            // the Queue will still on RabbitMQ and the error exception just 1 time
            throw new AmqpRejectAndDontRequeueException("Picture size too large : " + pic);

        }

        logger.info("On MyPicture : {}", pic);
    }
}
