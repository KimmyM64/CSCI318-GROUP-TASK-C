package com.example.demo.service;

import com.example.demo.domain.Payment;
import com.example.demo.domain.PaymentRequest;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
	
	//Create payment
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

//Update payment
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

	//Process payment
     public boolean processPayment(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setFlightId(request.getFlightId());
        payment.setPassengerId(request.getPassengerId());

        paymentRepository.save(payment);

        return true;

    }
    
//Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
