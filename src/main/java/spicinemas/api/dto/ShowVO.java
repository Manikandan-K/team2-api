package spicinemas.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@EqualsAndHashCode
@Getter
public class ShowVO {

    private long id;
    private String movieName;
    private String experiences;
    private String screenName;
    private String showTime;
    private long capacity;

    public ShowVO(long id, String movieName, String experiences, String screenName, Date showTime, long capacity) {
        this.id = id;
        this.movieName = movieName;
        this.experiences = experiences;
        this.screenName = screenName;
        this.capacity = capacity;
        this.showTime = formatShowTime(showTime);
    }

    private String formatShowTime(Date showTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        return dateFormat.format(showTime);
    }

    public long getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getExperiences() {
        return experiences;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getShowTime() {
        return showTime;
    }

    public long getCapacity() {
        return capacity;
    }
}
