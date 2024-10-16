package com.example.booking.client;

import com.example.booking.domain.PaymentDetails;
import org.springframework.stereotype.Component;
import com.example.passenger.domain;
import com.example.booking.client;
import com.example.booking.domain;
import com.example.booking.domain.Booking;
import com.example.booking.events.BookingEvent;
import com.example.booking.repository.BookingRepository;

@Component
public class PaymentServiceClient {

    public void processPayment(Long bookingId, PaymentDetails paymentDetails) {
        
        System.out.println("Processing payment for booking ID: " + bookingId);
    }
}
