package spicinemas.api.model;

import java.util.Date;

public class ShowBuilder {
    private Long movieId;
    private Long screenId;
    private Date showTime;

    public ShowBuilder setMovieId(long movieId) {
        this.movieId = movieId;
        return this;
    }

    public ShowBuilder setScreenId(long screenId) {
        this.screenId = screenId;
        return this;
    }

    public ShowBuilder setShowTime(Date showTime) {
        this.showTime = showTime;
        return  this;
    }

    public Show createShow() {
        return new Show(this.movieId, this.screenId, this.showTime);
    }
}
