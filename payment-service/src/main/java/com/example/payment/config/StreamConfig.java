package com.example.payment.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;

@EnableBinding(PaymentProcessor.class)
public class StreamConfig {
    public interface PaymentProcessor {
        String OUTPUT = "paymentOutput";
        String INPUT = "paymentInput";

        @Output(OUTPUT)
        MessageChannel paymentOutput();

        @Input(INPUT)
        SubscribableChannel paymentInput();
    }
}
