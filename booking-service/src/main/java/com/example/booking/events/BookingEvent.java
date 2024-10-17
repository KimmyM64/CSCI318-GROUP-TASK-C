package com.example.booking.events;

import java.io.Serializable;

public class BookingEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String passengerId; 
    private String flightId; 
    private String destLocation; 
    private double bookingAmount; 

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

    //Change output tos tring
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
