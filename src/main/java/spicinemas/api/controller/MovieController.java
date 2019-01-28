package spicinemas.api.controller;

import org.springframework.web.bind.annotation.RequestParam;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.management.MovieManagement;
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
    private MovieManagement movieManagement;

    @RequestMapping(value = "/init",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void init() {

        movieManagement.addMovie(new MovieBuilder().setName("Dunkirk").setExperiences("good").setListingType(MovieListingType.NOW_SHOWING).setReleaseDate(null).setSynopsis(null).setRunTime(0).setCast("").setCrew("").setBannerImageUrl("").setLanguageId(1l).createMovie());
    }

    @RequestMapping(value = "/movies",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,params = {"type","location","languages"})
    public List<Movie> getNowShowingMovies(@RequestParam(value = "type") String type,
                                           @RequestParam(value = "location") String location,
                                           @RequestParam(value = "languages") String languages
                                           ) {
        return movieManagement.getMovies(type,location,languages);
    }





}
