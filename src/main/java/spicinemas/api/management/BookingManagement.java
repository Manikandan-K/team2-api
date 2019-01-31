package spicinemas.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spicinemas.api.db.BookingRepository;
import spicinemas.api.db.ShowRepository;
import spicinemas.api.model.Booking;

@Component
public class BookingManagement {

    @Autowired
    BookingRepository bookingsRepository;

    public long createNewBooking(Booking bookingRequest) {
        return bookingsRepository.addBooking(bookingRequest);
    }
}
