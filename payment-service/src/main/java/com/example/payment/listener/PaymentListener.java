package com.example.payment.listener;

import com.example.payment.domain.Payment;
import com.example.payment.config.StreamConfig;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentListener {

    @StreamListener(StreamConfig.PaymentProcessor.INPUT)
    public void handlePayment(Payment payment) {
        // Display message 
        System.out.println("Received payment: " + payment);
        // need to add logic to process payment
    }
}
