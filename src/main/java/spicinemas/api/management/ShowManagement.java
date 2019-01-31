package spicinemas.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spicinemas.api.db.ShowRepository;
import spicinemas.api.dto.Show;

import java.util.Date;
import java.util.List;

@Component
public class ShowManagement {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> getShows(long movieId, long location, Date showDate) {
        return showRepository.getShows(movieId, location, showDate);
    }
}
