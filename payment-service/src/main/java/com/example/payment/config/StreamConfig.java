package com.example.payment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import java.util.function.Supplier;
import java.util.function.Consumer;

@Configuration
public class StreamConfig {

    // Send payment messages
    @Bean
    public Supplier<Message<String>> paymentOutput() {
        return () -> {
            // Need to modify
            return MessageBuilder.withPayload("Payment message")
                    .setHeader("type", "payment")
                    .build();
        };
    }

    // Recieve new message 
    @Bean
    public Consumer<Message<String>> paymentInput() {
        return message -> {
            
            System.out.println("Received payment: " + message.getPayload());
        };
    }
}
