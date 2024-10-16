package com.example.booking.events;

import java.io.Serializable;
import com.example.booking.client.PaymentServiceClient;
import com.example.booking.domain.Booking;
import com.example.booking.events.BookingEvent;
import com.example.booking.repository.BookingRepository;

public class BookingEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String passengerId; 
    private String flightId; 
    private String destLocation; 
    private double bookingAmount; 

    // Default constructor
    public BookingEvent() {
    }

    // Getters and Setters
    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getDestLocation() {
        return destLocation;
    }

    public void setDestLocation(String destLocation) {
        this.destLocation = destLocation;
    }

    public double getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(double bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    @Override
    public String toString() {
        return "BookingEvent{" +
                "passengerId='" + passengerId + '\'' +
                ", flightId='" + flightId + '\'' +
                ", destLocation='" + destLocation + '\'' +
                ", bookingAmount=" + bookingAmount +
                '}';
    }
}
