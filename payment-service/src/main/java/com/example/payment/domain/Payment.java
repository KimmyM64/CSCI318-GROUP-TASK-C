package com.example.payment.domain;

public class Payment {
    private Long id;
    private Double amount; 
    private Long flightId;
    private Long passengerId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() { 
        return amount;
    }

    public void setAmount(Double amount) { 
        this.amount = amount;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }
}
