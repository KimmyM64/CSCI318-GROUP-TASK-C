package com.example.payment.service;

import com.example.payment.domain.Payment;
import com.example.payment.domain.PaymentRequest;
import com.example.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.messaging.support.MessageBuilder;
import com.example.payment.config.StreamConfig;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;


import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @StreamListener("payment-input")
    public void handlePaymentEvent(@Payload Payment payment) {
        // Handle incoming payment events
        System.out.println("Processing payment: " + payment);
    }

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private StreamConfig.PaymentProcessor paymentProcessor;

    // Create a new payment
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Update an existing payment
    public Payment updatePayment(Long id, Payment payment) {
        Optional<Payment> existingPayment = paymentRepository.findById(id);
        if (existingPayment.isPresent()) {
            Payment updatedPayment = existingPayment.get();
            updatedPayment.setBank(payment.getBank());
            updatedPayment.setNumber(payment.getNumber());
            updatedPayment.setExpiry(payment.getExpiry());
            updatedPayment.setCvv(payment.getCvv());
            return paymentRepository.save(updatedPayment);
        } else {
            throw new RuntimeException("Payment not found");
        }
    }

    // Process payment request
    public boolean processPayment(PaymentRequest request) {
        // Create and save the payment
        Payment payment = new Payment();
        payment.setFlightId(request.getFlightId());
        payment.setPassengerId(request.getPassengerId());
        paymentRepository.save(payment);

        // Send message to the stream
        paymentProcessor.paymentOutput().send(MessageBuilder.withPayload(payment).build());

        return true;
    }

    // Retrieve all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
