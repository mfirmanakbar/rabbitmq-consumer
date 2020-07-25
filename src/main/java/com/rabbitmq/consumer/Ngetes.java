package com.rabbitmq.consumer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

//@Service
//@ConditionalOnProperty(
//    value = "module.enabled",
//    havingValue = "show-it",
//    matchIfMissing = true
//)
public class Ngetes {

    @Bean
    public void listen() {
        System.out.println("MUHAMMAD FIRMAN AKBAR");
    }

}
