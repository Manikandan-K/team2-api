package spicinemas.api.db;

import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.Show;
import spicinemas.api.model.ShowBuilder;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class ShowRepositoryTest {
    @Autowired
    private ShowRepository showRepo;
    @Autowired
    DSLContext dslContext;

    @Test
    public void shouldInsertShowInDb() {
        long screenId = 1;
        long movieId = 1;
        Date showTime = new Date();

        Show currentShow = new ShowBuilder()
                .setMovieId(movieId)
                .setScreenId(screenId)
                .setShowTime(showTime)
                .createShow();
        long showId = showRepo.addShow(currentShow);

        Show actualShow = showRepo.getShow(showId);
        assertThat(actualShow.getMovieId(), is(currentShow.getMovieId()));
        assertThat(actualShow.getSceenId(), is(screenId));
        assertThat(actualShow.getShowTime(), is(showTime));

    }
}
