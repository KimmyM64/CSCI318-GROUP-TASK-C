package com.example.booking.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.example.booking.client.PaymentServiceClient;
import com.example.flight.domain.Flight;
import com.example.booking.domain.Booking;
import com.example.booking.events.BookingEvent;
import com.example.booking.repository.BookingRepository;
import com.example.booking.service.BookingService;

@Entity
public class Booking {
    // Jakarta ID and GeneratedValue packages to organise auto IDs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long passengerId;
    private Long flightId;
    private double bookingAmount;
    private String destLocation;
   


    // Getters and Setters methods
    public Long getPassengerId() {
        return passengerId;
    }
    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

     public Long getFlightId() {
        return passengerId;
    }
    public void setFlightID(Long flight) {
        this.flightId = flightId;
    }

     public Long getBookingAmount() {
        return passengerId;
    }
    public double setBookingAmount(double bookingAmount) {
        this.flightId = flightId;
    }

    public String getDestLocation() {
        return destLocation;
    }
    public void setDestLocation(String destLocation) {
        this.destLocation = destLocation;
    }
}
