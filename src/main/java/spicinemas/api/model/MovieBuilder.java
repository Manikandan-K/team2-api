package spicinemas.api.model;

import spicinemas.api.type.MovieListingType;

import java.util.Date;

public class MovieBuilder {
    private String name;
    private String experiences;
    private MovieListingType listingType;
    private Date releaseDate;
    private String synopsis;
    private int runTime;
    private String cast;
    private String crew;
    private String bannerImageUrl;
    private Long languageId;

    public MovieBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MovieBuilder setExperiences(String experiences) {
        this.experiences = experiences;
        return this;
    }

    public MovieBuilder setListingType(MovieListingType listingType) {
        this.listingType = listingType;
        return this;
    }

    public MovieBuilder setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public MovieBuilder setSynopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }

    public MovieBuilder setRunTime(int runTime) {
        this.runTime = runTime;
        return this;
    }

    public MovieBuilder setCast(String cast) {
        this.cast = cast;
        return this;
    }

    public MovieBuilder setCrew(String crew) {
        this.crew = crew;
        return this;
    }

    public MovieBuilder setBannerImageUrl(String bannerImageUrl) {
        this.bannerImageUrl = bannerImageUrl;
        return this;
    }

    public MovieBuilder setLanguageId(Long languageId) {
        this.languageId = languageId;
        return this;
    }

    public Movie createMovie() {
        return new Movie(name, experiences, listingType, releaseDate, synopsis, runTime, cast, crew, bannerImageUrl, languageId);
    }
}