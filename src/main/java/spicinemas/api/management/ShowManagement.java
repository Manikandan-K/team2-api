package spicinemas.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spicinemas.api.db.ShowRepository1;
import spicinemas.api.model.Show;
import spicinemas.api.model.ShowVO;

import java.util.Date;
import java.util.List;

@Component
public class ShowManagement {

    @Autowired
    private ShowRepository1 showRepository;

    public List<ShowVO> getShows(long movieId, long location, Date showDate) {
        return showRepository.getShows(movieId, location, showDate);
    }

    public Show getShowById(long showId) {
        return showRepository.getShowById(showId);
    }
}
