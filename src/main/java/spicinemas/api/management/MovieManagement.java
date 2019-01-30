package spicinemas.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.db.ShowRepository;
import spicinemas.api.model.Movie;
import spicinemas.api.model.MovieBuilder;
import spicinemas.api.type.MovieListingType;

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


    public List<Movie> getMovies(String type, int location,String languages) {

        long locationId = Long.valueOf(location);
        List<Long> movieIds = showRepository.getDistinctMovieIdsByLocation(locationId);
        Long[] res = movieIds.toArray(new Long[0]);
        if(MovieListingType.NOW_SHOWING.toString().equalsIgnoreCase(type)) {
            return movieRepository.getNowShowingMoviesByIdsAndLanguageIds(new Long[]{1l},res);
        }else {
            return movieRepository.getUpcomingMoviesByIdsAndLanguageIds(new Long[]{1l},res);
        }

    }

    public Movie getMovieByName(String name) {
        return null;
    }

    public Movie getMovieById(int id) {
        return movieRepository.getMovieById(id);
    }


}
