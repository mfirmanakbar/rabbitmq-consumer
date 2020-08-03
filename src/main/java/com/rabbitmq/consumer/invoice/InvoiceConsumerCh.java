package com.rabbitmq.consumer.invoice;

import com.rabbitmq.entity.InvoiceCreatedMessage;
import com.rabbitmq.entity.InvoicePaidMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"q.ch-invoice.one", "q.ch-invoice.two", "q.ch-invoice.three"})
public class InvoiceConsumerCh {

    public static final Logger logger = LoggerFactory.getLogger(InvoiceConsumerCh.class);

    @RabbitHandler
    public void handleInvoiceCreated(InvoiceCreatedMessage message) {
        logger.info("Invoice {}: {}", message.getInvoiceNumber(), message);
    }

    @RabbitHandler
    public void handleInvoicePaid(InvoicePaidMessage message) {
        logger.info("Payment {}: {}", message.getPaymentNumber(), message);
    }

    @RabbitHandler(isDefault = true)
    public void handleDefaultObject(Object message) {
        logger.info("Default: {}", message);
    }

}
