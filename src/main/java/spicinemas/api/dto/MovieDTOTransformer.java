package spicinemas.api.dto;

import spicinemas.api.model.Movie;

public class MovieDTOTransformer {

    public static MovieVO getMovieVOFromEntity(Movie movie, String language){
        return new MovieVOBuilder()
                .setBannerImageUrl(movie.getBannerImageUrl())
                .setCast(movie.getCast())
                .setCrew(movie.getCrew())
                .setExperiences(movie.getExperiences())
                .setId(movie.getId())
                .setLanguage(language)
                .setName(movie.getName())
                .setReleaseDate(movie.getReleaseDate())
                .setRunTime(movie.getRunTime())
                .setSynopsis(movie.getSynopsis())
                .createMovieVO();
    }
}
