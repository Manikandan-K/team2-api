package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Show;
import spicinemas.api.model.ShowVO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ShowRepository1 {
    @Autowired
    private DSLContext dsl;

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
    
    public Show getShowById(long showId) {
        return dsl.select()
                .from(DSL.table("Show"))
                .where(DSL.field("id").eq(showId))
                .fetchInto(Show.class)
                .get(0);
    }
}
