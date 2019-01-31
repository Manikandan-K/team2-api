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

import spicinemas.api.dto.ShowVO;
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
    private LanguageRepository langRep;

    @Autowired
    private LocationRepository locationRep;

    @Autowired
    private ScreenRepository screenRep;

    @Autowired
    private MovieRepository movieRep;

    @Autowired
    DSLContext dslContext;


    @Test
    public void getDistinctMovieIdsByLocation() {
        List movieIds = showRepository.getDistinctMovieIdsByLocation(1);
       Assert.assertTrue(movieIds.size()>0);
    }

    public void shouldInsertShowInDb() {
        Language language = new Language("Telugu");
        long languageId = langRep.addLanguage(language);
        language = langRep.getLanguageByName("Telugu");

        Location location = new Location("chennai");
        long locationId = locationRep.addLocation(location);

        Screen screen = new Screen("PVR X", locationId, 100);
        long screenId = screenRep.addScreen(screen);

        Movie movie = new Movie("Star wars", "IMAX", new Date(), "asdf", 150, "a, b", "c, d", "asdf", languageId);
        long movieId = movieRep.addMovie(movie);

        Date showTime = new Date();

        spicinemas.api.model.Show currentShow = new ShowBuilder()
                .setMovieId(movieId)
                .setScreenId(screenId)
                .setShowTime(showTime)
                .createShow();
        long showId = showRepository.addShow(currentShow);

        spicinemas.api.model.Show actualShow = showRepository.getShow(showId);
        assertThat(actualShow.getMovieId(), is(currentShow.getMovieId()));
        assertThat(actualShow.getScreenId(), is(screenId));
        assertThat(actualShow.getShowTime(), is(showTime));

    }

    @Test
    public void shouldReturnMovieShows() {
        List<ShowVO> shows = showRepository.getShows(1, 1, new Date());
        Assert.assertNotNull(shows);
    }
}
