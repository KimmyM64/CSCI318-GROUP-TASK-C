package com.example.payment.service;

import com.example.payment.domain.Payment;
import com.example.payment.domain.PaymentRequest;
import com.example.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private StreamConfig.PaymentProcessor paymentProcessor;

    @StreamListener("payment-input")
    public void handlePaymentEvent(@Payload Payment payment) {
        System.out.println("Processing payment: " + payment);
    }

    // Create a new payment
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Update an existing payment
    public Payment updatePayment(Long id, Payment payment) {
    // Find existing payment by ID
    Optional<Payment> existingPayment = paymentRepository.findById(id);
    
    return existingPayment.map(existing -> {
        // Update existing payment 
        existing.setAmount(payment.getAmount());
        existing.setFlightId(payment.getFlightId());
        existing.setPassengerId(payment.getPassengerId());
        // Save and return the updated payment
        return paymentRepository.save(existing);
    }).orElseThrow(() -> new RuntimeException("Payment not found with ID: " + id));
}

    // Process payment request
    public boolean processPayment(PaymentRequest request) {

        // Create and save payment
        Payment payment = new Payment();
        payment.setFlightId(request.getFlightId());
        payment.setPassengerId(request.getPassengerId());
        paymentRepository.save(payment);

        // Send message to the stream
        paymentProcessor.paymentOutput().send(MessageBuilder.withPayload(payment).build());
        return true;
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
