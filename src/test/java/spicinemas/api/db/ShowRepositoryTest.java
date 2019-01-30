package spicinemas.api.db;

import org.jooq.DSLContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;

import java.util.List;
import spicinemas.api.model.*;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class ShowRepositoryTest {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    DSLContext dslContext;


    @Test
    public void getDistinctMovieIdsByLocation() {
        List movieIds = showRepository.getDistinctMovieIdsByLocation(1);
       Assert.assertEquals(1, movieIds.size());
       Assert.assertEquals(1l,movieIds.get(0));
    }

    @Test
    public void shouldInsertShowInDb() {
        LanguageRepository langRep = new LanguageRepository();
//        Language language = new Language("tamil");
//        langRep.addLanguage(language);
        Language language = langRep.getLanguageByName("Tamil");

        LocationRepository locationRep = new LocationRepository();
        Location location = new Location("chennai");
        long locationId = locationRep.addLocation(location);

        ScreenRepository screenRep = new ScreenRepository();
        Screen screen = new Screen("PVR X", locationId, 100);
        long screenId = screenRep.addScreen(screen);

        MovieRepository movieRep = new MovieRepository();
        Movie movie = new Movie("Star wars", "IMAX", new Date(), "asdf", 150, "a, b", "c, d", "asdf", language.getId());
        long movieId = movieRep.addMovie(movie);

        Date showTime = new Date();

        Show currentShow = new ShowBuilder()
                .setMovieId(movieId)
                .setScreenId(screenId)
                .setShowTime(showTime)
                .createShow();
        long showId = showRepository.addShow(currentShow);

        Show actualShow = showRepository.getShow(showId);
        assertThat(actualShow.getMovieId(), is(currentShow.getMovieId()));
        assertThat(actualShow.getSceenId(), is(screenId));
        assertThat(actualShow.getShowTime(), is(showTime));

    }
}
