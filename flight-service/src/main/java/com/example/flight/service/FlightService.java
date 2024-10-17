package com.example.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.messaging.Message;
import com.example.flight.domain.Flight;
import com.example.flight.repository.FlightRepository;
import com.example.flight.config.KafkaConfig;  

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private KafkaConfig.FlightProcessor flightProcessor; 

    // Create a Flight
    public Flight createFlight(Flight flight) {
        Flight createdFlight = flightRepository.save(flight);
        publishFlightEvent(createdFlight, "created");
        return createdFlight;
    }

    // Update a Flight
    public Flight updateFlight(Long id, Flight flight) {
        Flight existingFlight = flightRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Flight ID does not exist"));

        existingFlight.setDate(flight.getDate());
        existingFlight.setTime(flight.getTime());
        existingFlight.setStart(flight.getStart());
        existingFlight.setDestination(flight.getDestination());

        Flight updatedFlight = flightRepository.save(existingFlight);
        publishFlightEvent(updatedFlight, "updated");
        return updatedFlight;
    }

    // Get all Flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Publish flight events
    private void publishFlightEvent(Flight flight, String eventType) {
     String payload = String.format("{\"id\": %d, \"eventType\": \"%s\"}", flight.getId(), eventType);
    
    // Publish the event to the Kafka topic
    flightProcessor.flightOutput().send(MessageBuilder.withPayload(payload).build());
}
}
