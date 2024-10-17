package com.example.passenger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.passenger.domain.Passenger;
import com.example.passenger.repository.PassengerRepository;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    // Create a Passenger
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    // Update a Passenger
    public Passenger updatePassenger(Long id, Passenger passenger) {
        Passenger existingPassenger = passengerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Passenger ID does not exist"));

        existingPassenger.setFirstName(passenger.getFirstName());
        existingPassenger.setLastName(passenger.getLastName()); 
        existingPassenger.setEmail(passenger.getEmail());

        return passengerRepository.save(existingPassenger);
    }

    // Get all Passengers
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }
}
