package com.example.flight.controller;

import com.example.flight.domain.Flight;
import com.example.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // Create a Flight
    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight createdFlight = flightService.createFlight(flight);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

    // Update a Flight
    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        Flight updatedFlight = flightService.updateFlight(id, flight);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    // Get all Flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() { 
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}
