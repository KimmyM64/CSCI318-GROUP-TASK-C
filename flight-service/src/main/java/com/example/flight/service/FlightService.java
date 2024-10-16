package com.example.flight.service;

import com.example.flight.domain.Flight;
import com.example.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.flight.client.PaymentClient; 

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PaymentClient paymentClient; 

    // Create a Flight
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Update a Flight
    public Flight updateFlight(Long id, Flight flight) {
        Flight existingFlight = flightRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Flight ID does not exist"));

        existingFlight.setDate(flight.getDate());
        existingFlight.setTime(flight.getTime());
        existingFlight.setStart(flight.getStart());
        existingFlight.setDestination(flight.getDestination());

        return flightRepository.save(existingFlight);
    }

    // Get all Flights
    public List<Flight> getAllFlights() {
        
        return flightRepository.findAll();
    }

    public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(String message) {
        super(message);
    }
}

}
