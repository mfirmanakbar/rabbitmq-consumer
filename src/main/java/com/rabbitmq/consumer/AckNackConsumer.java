package com.rabbitmq.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Service
public class AckNackConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(AckNackConsumer.class);

//    @RabbitListener(queues = "q.dummy")
//    public void listen(String message) {
//        logger.info("MSG: {}", message);
//    }

    @RabbitListener(queues = "q.dummy.direct.a")
    public void listenA(Message message, Channel channel) throws IOException {
        String keys = message.getMessageProperties().getReceivedRoutingKey();
        String msg = new String(message.getBody());
        if (!msg.equalsIgnoreCase("Sync Outlet 3") && !msg.equalsIgnoreCase("Sync Outlet 4")) {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            logger.info("YES-ACK `{}` and key `{}`", msg, keys);
        } else {
            logger.info("NOT-ACK`{}` and key `{}`", msg, keys);
        }
    }

    @RabbitListener(queues = "q.dummy.direct.b")
    public void listenB(Message message, Channel channel) throws IOException {
        String keys = message.getMessageProperties().getReceivedRoutingKey();
        String msg = new String(message.getBody());
        if (!msg.equalsIgnoreCase("Sync Outlet 3") && !msg.equalsIgnoreCase("Sync Outlet 4")) {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            logger.info("YES-ACK `{}` and key `{}`", msg, keys);
        } else {
            logger.info("NOT-ACK`{}` and key `{}`", msg, keys);
        }
    }

//    private final CountDownLatch latch = new CountDownLatch(1);
//
//    @RabbitListener(queues = "q.dummy")
//    public void receive(String payload, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag)
//            throws IOException {
//        logger.info("payload: {}", payload);
//        channel.basicAck(tag, false);
//        latch.countDown();
//    }

}
