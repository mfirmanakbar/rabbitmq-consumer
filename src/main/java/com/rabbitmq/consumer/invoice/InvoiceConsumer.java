package com.rabbitmq.consumer.invoice;

import com.rabbitmq.entity.InvoiceCreatedMessage;
import com.rabbitmq.entity.InvoicePaidMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "q.invoice")
public class InvoiceConsumer {

    public static final Logger logger = LoggerFactory.getLogger(InvoiceConsumer.class);

    @RabbitHandler
    public void handleInvoiceCreated(InvoiceCreatedMessage message) {
        logger.info("on handleInvoiceCreated : {}", message);
    }

    @RabbitHandler
    public void handleInvoicePaid(InvoicePaidMessage message) {
        logger.info("on handleInvoicePaid : {}", message);
    }

    @RabbitHandler(isDefault = true)
    public void handleDefaultObject(Object message) {
        logger.info("on handleDefaultObject : {}", message);
    }

}
