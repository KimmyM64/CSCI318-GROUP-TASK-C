package com.example.demo;

import com.example.demo.service.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookingServiceApplicationTests {

    @Autowired
    private BookingService bookingService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void bookingServiceIsNotNull() {
        assertThat(bookingService).isNotNull();
    }

    @Test
    public void testBookingCreation() {
      	Booking booking = new Booking();
        booking.setFlightId(123L);
        booking.setPassengerId(456L);
        bookingService.createBooking(booking);
		booking.setFace();
    }
}
