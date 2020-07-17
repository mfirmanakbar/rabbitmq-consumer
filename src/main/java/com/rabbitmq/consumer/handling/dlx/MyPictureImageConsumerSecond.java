package com.rabbitmq.consumer.handling.dlx;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class MyPictureImageConsumerSecond {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Logger logger = LoggerFactory.getLogger(MyPictureImageConsumerSecond.class);

    @RabbitListener(queues = "q.mypicture.image")
    public void listen(Message message, Channel channel) throws IOException {
        Picture pic = objectMapper.readValue(message.getBody(), Picture.class);
        if (pic.getSize() > 9000) {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        }
        logger.info("On MyPicture : {}", pic);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
