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
import spicinemas.api.model.Movie;
import spicinemas.api.model.MovieBuilder;
import spicinemas.api.type.MovieListingType;

import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepo;
    @Autowired
    DSLContext dslContext;

    @Test
    public void shouldReturnNowShowingMovies(){
        List<Movie> nowShowingList = movieRepo.getNowShowingMovies(new long[]{1l});
        Assert.assertEquals(8,nowShowingList.size());
    }


    @Test
    public void shouldReturnUpcomingMovies(){
        List<Movie> upcomingMovies = movieRepo.geUpcomingMovies(new long[]{1l});
        Assert.assertEquals(0,upcomingMovies.size());
    }

    @Test
    public void shouldInsertMovieInDb(){
        String movieName = "Infinity War";

        Movie expectedMovie = new MovieBuilder().setName(movieName).setExperiences("okay").setReleaseDate(new Date()).setSynopsis("").setRunTime(160).setCast("A B").setCrew("C D").setBannerImageUrl("imgUrl").setLanguageId(1l).createMovie();
        movieRepo.addMovie(expectedMovie);
        Movie actualMovie = movieRepo.getMovie(movieName);
        assertThat(actualMovie.getName(), is(expectedMovie.getName()));
        assertThat(actualMovie.getExperiences(), is(expectedMovie.getExperiences()));
    }
}