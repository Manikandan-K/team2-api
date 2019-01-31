package spicinemas.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spicinemas.api.db.ShowRepository;
import spicinemas.api.dto.ShowVO;
import spicinemas.api.model.Show;

import java.util.Date;
import java.util.List;

@Component
public class ShowManagement {

    @Autowired
    private ShowRepository showRepository;

    public List<ShowVO> getShows(long movieId, long location, Date showDate) {
        return showRepository.getShows(movieId, location, showDate);
    }

    public Show getShowById(long showId) {
        return showRepository.getShowById(showId);
    }
}
