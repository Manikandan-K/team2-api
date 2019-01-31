package spicinemas.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.management.BookingManagement;
import spicinemas.api.management.ScreenManagement;
import spicinemas.api.management.ShowManagement;
import spicinemas.api.model.Booking;
import spicinemas.api.model.Screen;
import spicinemas.api.model.Show;


@RestController
public class BookingController {
    @Autowired
    BookingManagement bookingManagement;

    @Autowired
    ShowManagement showManagement;

    @Autowired
    ScreenManagement screenManagement;


    private static final Logger LOG = LoggerFactory.getLogger(BookingController.class);

    @PostMapping(value="/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Show show = showManagement.getShowById(booking.getShowId());
        long alreadyBooked = bookingManagement.getNumberOfSeatsBookedForShow(show.getId());
        Screen screen = screenManagement.getScreenById(show.getScreenId());
        int screenCapacity = screen.getCapacity();

        // Validate
        if (booking.getNumberOfSeats() <= (screenCapacity - alreadyBooked)) {
            long bookingId = bookingManagement.createNewBooking(booking);
            return ResponseEntity.status(HttpStatus.OK).body(bookingManagement.getBookingById(bookingId));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
