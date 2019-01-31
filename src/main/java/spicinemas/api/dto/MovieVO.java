package spicinemas.api.dto;

import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode
public class MovieVO {
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

    public  MovieVO() {}

    public MovieVO(Long id, String name, String experiences, Date releaseDate, String synopsis, int runTime, String cast, String crew, String bannerImageUrl, String language) {
        this.id = id;
        this.name = name;
        this.experiences = experiences;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
        this.runTime = runTime;
        this.cast = cast;
        this.crew = crew;
        this.bannerImageUrl = bannerImageUrl;
        this.language = language;
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

    public String getLanguage() {
        return language;
    }
}
