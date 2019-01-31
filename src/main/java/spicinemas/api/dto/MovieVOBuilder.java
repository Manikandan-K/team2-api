package spicinemas.api.dto;

import java.util.Date;

public class MovieVOBuilder {
    private Long id;
    private String name;
    private String experiences;
    private Date releaseDate;
    private String synopsis;
    private int runTime;
    private String cast;
    private String crew;
    private String bannerImageUrl;
    private String language;

    public MovieVOBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public MovieVOBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MovieVOBuilder setExperiences(String experiences) {
        this.experiences = experiences;
        return this;
    }

    public MovieVOBuilder setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public MovieVOBuilder setSynopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }

    public MovieVOBuilder setRunTime(int runTime) {
        this.runTime = runTime;
        return this;
    }

    public MovieVOBuilder setCast(String cast) {
        this.cast = cast;
        return this;
    }

    public MovieVOBuilder setCrew(String crew) {
        this.crew = crew;
        return this;
    }

    public MovieVOBuilder setBannerImageUrl(String bannerImageUrl) {
        this.bannerImageUrl = bannerImageUrl;
        return this;
    }

    public MovieVOBuilder setLanguage(String language) {
        this.language = language;
        return this;
    }

    public MovieVO createMovieVO() {
        return new MovieVO(id, name, experiences, releaseDate, synopsis, runTime, cast, crew, bannerImageUrl, language);
    }
}