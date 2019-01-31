package spicinemas.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@EqualsAndHashCode
@Getter
public class Show {

    private long id;
    private String movieName;
    private String experiences;
    private String screenName;
    private Date showTime;
    private long capacity;

    public Show(long id, String movieName, String experiences, String screenName, Date showTime, long capacity) {
        this.id = id;
        this.movieName = movieName;
        this.experiences = experiences;
        this.screenName = screenName;
        this.capacity = capacity;
        this.showTime = showTime;
    }

//    public long getId() {
//        return id;
//    }
//
//    public String getMovieName() {
//        return movieName;
//    }
//
//    public String getExperiences() {
//        return experiences;
//    }
//
//    public String getScreenName() {
//        return screenName;
//    }
//
//    public Date getShowTime() {
//        return showTime;
//    }
//
//    public long getCapacity() {
//        return capacity;
//    }
}
