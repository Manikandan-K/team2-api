package spicinemas.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.db.ShowRepository;
import spicinemas.api.model.Movie;
import spicinemas.api.model.MovieBuilder;

import java.util.Arrays;
import java.util.List;

@Component
public class MovieManagement {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;


    public void addMovie(Movie movie) {
    }


    public List<Movie> getMovies(String type, String location) {

        long locationId = 1l;
        List<Long> movieIds = showRepository.getDistinctMovieIdsByLocation(locationId);
        Long[] res = movieIds.toArray(new Long[0]);
        return movieRepository.getNowShowingMoviesByIdsAndLanguageIds(new Long[1],res);
    }

    public Movie getMovieByName(String name) {
        return null;
    }

    public Movie getMovieById(int id) {
        return movieRepository.getMovieById(id);
    }


}
