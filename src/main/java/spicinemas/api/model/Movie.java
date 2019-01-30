package spicinemas.api.model;

import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(exclude = {"id"})
public class Movie {
    private Long id;
    private String name;
    private String experiences;
    private Date releaseDate;
    private String synopsis;
    private int runTime;
    private String cast;
    private String crew;
    private String bannerImageUrl;
    private Long languageId;


    public Movie(String name, String experiences, Date releaseDate, String synopsis, int runTime, String cast, String crew, String bannerImageUrl, Long languageId) {
        this.name = name;
        this.experiences = experiences;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
        this.runTime = runTime;
        this.cast = cast;
        this.crew = crew;
        this.bannerImageUrl = bannerImageUrl;
        this.languageId = languageId;
    }

    public Movie() {

    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getRunTime() {
        return runTime;
    }

    public String getCast() {
        return cast;
    }

    public String getCrew() {
        return crew;
    }

    public String getBannerImageUrl() {
        return bannerImageUrl;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExperiences() {
        return experiences;
    }

}