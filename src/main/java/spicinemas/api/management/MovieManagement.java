package spicinemas.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.model.Movie;
import spicinemas.api.model.MovieBuilder;

import java.util.Arrays;
import java.util.List;

@Component
public class MovieManagement {

    @Autowired
    private MovieRepository movieRepository;


    public void addMovie(Movie movie) {
    }


    public List<Movie> getMovies(String type, String location, String languages) {
        return movieRepository.getNowShowingMovies(new long[1]);
    }

    public Movie getMovieByName(String name) {
        return null;
    }

    public Movie getMovieById(int id) {
        return movieRepository.getMovieById(id);
    }


}
