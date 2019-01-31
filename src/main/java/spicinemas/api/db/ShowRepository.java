package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.dto.ShowVO;
import spicinemas.api.model.Show;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ShowRepository {
    @Autowired
    private DSLContext dsl;
    public long addShow(Show currentShow) {
        return (long) dsl.insertInto(DSL.table("Show"))
                .columns(DSL.field("screenId"), DSL.field("movieId"), DSL.field("showTime"))
                .values(currentShow.getScreenId(), currentShow.getMovieId(), currentShow.getShowTime())
                .returning(DSL.field("id"))
                .fetchOne()
                .get(DSL.field("id"));
    }

    public Show getShow(long showId) {
        return dsl.select(DSL.field("id"), DSL.field("showTime"))
                .from(DSL.table("Show"))
                .where(DSL.field("Show.id").eq(showId))
                .fetchOne()
                .into(Show.class);
    }

    public List<ShowVO> getShows(long movieId, long location, Date showDate) {

        return dsl.select(DSL.field("Show.id").as("id"),
                DSL.field("Movie.name").as("movieName"),
                DSL.field("Movie.experiences").as("experiences"),
                DSL.field("Screen.name").as("screenName"),
                DSL.field("Show.showTime").as("showTime"),
                DSL.field("Screen.capacity").as("capacity"))
                .from(DSL.table("Show"))
                .leftOuterJoin(DSL.table("Screen"))
                .on(DSL.field("Show.screenId").eq(DSL.field("Screen.id")))

                .leftOuterJoin(DSL.table("Movie"))
                .on(DSL.field("Show.movieId").eq(DSL.field("Movie.id")))

                .where("movieId = " + movieId)
                .and("locationId = "+ location)
                .and("showTime >= '"+ showDate +"'::date")
                .and("showTime < ('"+ showDate +"'::date + '1 day'::interval)")
                .fetchInto(ShowVO.class);
    }

    public List getDistinctMovieIdsByLocation(long locationId) {

        String query = "select Show.movieId from Show join Screen on Show.screenId = Screen.id where Screen.locationId ="+locationId;
        List records = dsl.fetch(query).getValues(0);
        return records;

    }

    public Show getShowById(long showId) {
        return dsl.select()
                .from(DSL.table("Show"))
                .where(DSL.field("id").eq(showId))
                .fetchInto(Show.class)
                .get(0);
    }
}
