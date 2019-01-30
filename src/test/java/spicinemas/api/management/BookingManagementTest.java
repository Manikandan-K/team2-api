package spicinemas.api.management;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.db.BookingRepository;
import spicinemas.api.model.Booking;
import spicinemas.api.model.BookingBuilder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class BookingManagementTest {

    @Before
    public void prepareData() {
        dsl.deleteFrom(DSL.table("public.\"Booking\"")).execute();
    }

    @After
    public void cleanupData(){
        dsl.deleteFrom(DSL.table("public.\"Booking\"")).execute();
    }

    @Autowired
    private DSLContext dsl;

    @Autowired
    BookingManagement bookingManagement;

    @Autowired
    BookingRepository bookingRepository;

    @Ignore
    @Test
    public void givenUnlimitedSeatsShouldCreateBooking() {
        long showId = 420L;
        String userName = "Test User";
        String userEmail = "testuser@gmail.com";
        int numberOfSeats = 5;
        Booking booking = new BookingBuilder().forShow(showId)
                              .forUser(userName, userEmail)
                              .blockingSeats(numberOfSeats)
                              .createBooking();

        long bookingId = bookingManagement.createNewBooking(booking);
        Booking createdBooking = bookingRepository.getBooking(bookingId);

        assertThat(createdBooking.getShowId(), is(showId));
        assertThat(createdBooking.getUserName(), is(userName));
        assertThat(createdBooking.getUserEmail(), is(userEmail));
        assertThat(createdBooking.getNumberOfSeats(), is(numberOfSeats));
    }
}
