package com.example.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.booking.domain.Booking;
import com.example.booking.events.BookingEvent;
import com.example.booking.repository.BookingRepository;
import com.example.booking.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private KafkaTemplate<String, BookingEvent> kafkaTemplate;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.createBooking(booking);

        // Create and publish booking event
        BookingEvent bookingEvent = new BookingEvent();
        bookingEvent.setPassengerId(savedBooking.getPassengerId().toString());
        bookingEvent.setFlightId(savedBooking.getFlightId().toString());
        bookingEvent.setDestLocation(savedBooking.getDestLocation());
        bookingEvent.setBookingAmount(savedBooking.getBookingAmount());
    }

    @PostMapping("/events")
    public ResponseEntity<String> sendBookingEvent(@RequestBody BookingEvent bookingEvent) {
        // Send booking event to Kafka
        kafkaTemplate.send("booking-events", bookingEvent);
        return ResponseEntity.ok("Booking event sent to Kafka: " + bookingEvent);
    }
}
