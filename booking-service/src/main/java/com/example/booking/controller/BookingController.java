package com.example.booking.controller;

import com.example.flight.domain.Flight;
import com.example.booking.client.PaymentServiceClient;
import com.example.booking.domain.Booking;
import com.example.booking.events.BookingEvent;
import com.example.booking.repository.BookingRepository;
import com.example.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private KafkaTemplate<String, BookingEvent> kafkaTemplate;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.createBooking(booking);

        // Create and publish booking event
        BookingEvent bookingEvent = new BookingEvent();
        bookingEvent.setPassengerId(savedBooking.getPassengerId());
        bookingEvent.setFlightId(savedBooking.getFlightId());
        bookingEvent.setDestLocation("");
        bookingEvent.setBookingAmount(1);

        // Send the booking event to Kafka
        kafkaTemplate.send("booking-events", bookingEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
    }
}
