package com.rabbitmq.consumer.exchange.direct.picture;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

//@Service
public class VectorConsumer {

    private Logger logger = LoggerFactory.getLogger(VectorConsumer.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "q.picture.vector")
    public void listen(String message) {
        Picture pic;
        try {
            pic = objectMapper.readValue(message, Picture.class);
            logger.info("On Vector : {}", pic);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
