package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.management.BookingManagement;
import spicinemas.api.model.Booking;


@RestController
public class BookingController {
    @Autowired
    BookingManagement bookingManagement;

    @PostMapping(value="/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public long createBooking(@RequestBody Booking booking) {
        return bookingManagement.createNewBooking(booking);
    }
}
