package spicinemas.api.controller;

import spicinemas.api.db.MovieRepository;
import spicinemas.api.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.model.MovieBuilder;
import spicinemas.api.type.MovieListingType;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieRepository movieRepo;

    @RequestMapping(value = "/init",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void init() {

        movieRepo.addMovie(new MovieBuilder().setName("Dunkirk").setExperiences("good").setListingType(MovieListingType.NOW_SHOWING).setReleaseDate(null).setSynopsis(null).setRunTime(0).setCast("").setCrew("").setBannerImageUrl("").setLanguageId(1l).createMovie());
    }

    @RequestMapping(value = "/movies/now-showing",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getNowShowingMovies() {
        return movieRepo.getNowShowingMovies();
    }

}
