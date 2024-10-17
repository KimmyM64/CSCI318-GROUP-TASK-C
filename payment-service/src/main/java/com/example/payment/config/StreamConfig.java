package com.example.payment.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import java.util.function.Supplier;
import java.util.function.Consumer;

@EnableBinding(StreamConfig.PaymentProcessor.class)
@Configuration
public class StreamConfig {

    public interface PaymentProcessor {
        String OUTPUT = "payment-output";
        String INPUT = "payment-input";

        @Output(OUTPUT)
        MessageChannel paymentOutput();

        @Input(INPUT)
        SubscribableChannel paymentInput();
    }

    // Send payment messages
    @Bean
    public Supplier<Message<String>> paymentOutput() {
        return () -> MessageBuilder.withPayload("Payment message")
                .setHeader("type", "payment")
                .build();
    }

    // Receive new message 
    @Bean
    public Consumer<Message<String>> paymentInput() {
        return message -> {
            System.out.println("Received payment: " + message.getPayload());
        };
    }
}
