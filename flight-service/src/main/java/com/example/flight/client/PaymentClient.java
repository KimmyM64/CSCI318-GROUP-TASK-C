package com.example.flight.client;

import org.springframework.stereotype.Component;

@Component
public class PaymentClient {
    
    public void initiatePayment(String paymentDetails) {
        // Have to implement payment logic here
        System.out.println("Payment processed with details: " + paymentDetails);
    }
}
