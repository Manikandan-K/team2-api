package spicinemas.api.model;

import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode
public class Show {

    private Long id;
    private Long screenId;
    private Long movieId;
    private Date showTime;

    public Show(Long id, Long screenId, Long movieId, Date showTime) {
        this.id = id;
        this.screenId = screenId;
        this.movieId = movieId;
        this.showTime = showTime;
    }

    public Long getId() {
        return id;
    }

    public Long getScreenId() {
        return screenId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Date getShowTime() {
        return showTime;
    }
}
