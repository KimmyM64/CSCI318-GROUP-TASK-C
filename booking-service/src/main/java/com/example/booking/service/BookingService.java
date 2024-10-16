package com.example.booking.service;

import com.example.booking.client.PaymentServiceClient;
import com.example.booking.domain.Booking;
import com.example.booking.domain.BookingRequest;
import com.example.booking.events.BookingEvent;
import com.example.booking.repository.BookingRepository;
import com.example.flight.domain.Flight;
import com.example.passenger.domain.Passenger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResourceNotFoundException;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FlightServiceClient flightServiceClient; 
    private final PaymentServiceClient paymentServiceClient;

    @Autowired
    public BookingService(BookingRepository bookingRepository, 
                          FlightServiceClient flightServiceClient, 
                          PaymentServiceClient paymentServiceClient) {
        this.bookingRepository = bookingRepository;
        this.flightServiceClient = flightServiceClient;
        this.paymentServiceClient = paymentServiceClient;
    }

    public Booking createBooking(BookingRequest request) {
        // Check flight availability
        Flight flight = flightServiceClient.getFlight(request.getFlightId());

        if (flight == null) {
            throw new ResourceNotFoundException("Flight not found with id: " + request.getFlightId());
        }

        if (!flight.isAvailable()) {
            throw new RuntimeException("Flight not available");
        }

        Booking booking = new Booking(request);
        
        // Save the booking
        Booking savedBooking = bookingRepository.save(booking);

        // Process payment
        try {
            paymentServiceClient.processPayment(savedBooking.getId(), request.getPaymentDetails());
        } catch (Exception e) {
            throw new RuntimeException("Payment processing failed: " + e.getMessage(), e);
        }
        return savedBooking; 
    }
}
