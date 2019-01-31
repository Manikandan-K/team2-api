package spicinemas.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spicinemas.api.db.ShowRepository;
import spicinemas.api.dto.Show;
import spicinemas.api.db.ShowRepository1;
import spicinemas.api.model.Show;
import spicinemas.api.model.ShowVO;

import java.util.Date;
import java.util.List;

@Component
public class ShowManagement {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> getShows(long movieId, long location, Date showDate) {
        return showRepository.getShows(movieId, location, showDate);
    }

    public Show getShowById(long showId) {
        return showRepository.getShowById(showId);
    }
}
