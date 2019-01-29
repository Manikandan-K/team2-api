package spicinemas.api.db;


import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.*;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class BookingRepositoryTest {
    @Autowired
    private BookingRepository bookingRepo;
    @Autowired
    DSLContext dslContext;

    @Test
    public void shouldCreateBookingInDb() {
//        Create a show
        LanguageRepository langRep = new LanguageRepository();
        Language language = langRep.getLanguageByName("tamil");


        MovieRepository movieRep = new MovieRepository();
        Movie movie = new Movie("Star wars", "IMAX", null, new Date(), "asdf", 150, "a, b", "c, d", "asdf", language.getId());
        long movieId = movieRep.addMovie(movie);

        ScreenRepository screenRep = new ScreenRepository();
        Screen screen = new Screen("PVR X", )

        ShowRepository showRep = new ShowRepository();
        Show show = new Show(screenId, movieId, new Date());

//        User details
        String userName = "user 1";
        String userEmail = "user1@domain.com";

        Booking showBooking = new BookingBuilder().setShow(show).setUserName(userName).setUserEmail(userEmail).createBooking();
        long bookingId = bookingRepo.addBooking(showBooking);

        Booking currentBooking = bookingRepo.getBooking(bookingId);
        assertThat(currentBooking.getUserName(), is(showBooking.getUserName()));
        assertThat(currentBooking.getUserEmail(), is(showBooking.getUserEmail()));
        assertThat(currentBooking.getShowId(), is(showBooking.getShowId()));
    }
}
