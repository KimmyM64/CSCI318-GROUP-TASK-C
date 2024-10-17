package com.example.flight.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.cloud.stream.annotation.Output;

//Code for Kafka
@EnableBinding(KafkaConfig.FlightProcessor.class)
public class KafkaConfig {

    public interface FlightProcessor {
        String FLIGHT_OUTPUT = "flight-output";

        @Output(FLIGHT_OUTPUT)
        MessageChannel flightOutput();
    }
}
