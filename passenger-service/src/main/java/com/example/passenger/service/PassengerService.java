package com.example.passenger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.passenger.domain.Passenger;
import com.example.passenger.repository.PassengerRepository;

@Service
public class PassengerService {

    // AutoWired package to incorporate the Repository file
    @Autowired
    private PassengerRepository passengerRepository;

    // Create a Passenger
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    // Update a Passenger
    public Passenger updatePassenger(Long id, Passenger passenger) {
        Passenger newPassenger = passengerRepository.findById(id).orElseThrow(() -> new RuntimeException("Passenger ID does not exist"));

        newPassenger.setFirstName(passenger.getFirstName());
        newPassenger.setLastname(passenger.getLastName());
        newPassenger.setEmail(passenger.getEmail());

        return passengerRepository.save(newPassenger);
    }

    // Get all Passengers
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }
}
