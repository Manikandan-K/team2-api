package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spicinemas.api.model.Show;

@Repository
@Transactional
public class ShowRepository {
    @Autowired
    private DSLContext dsl;
    public long addShow(Show currentShow) {
        return (long) dsl.insertInto(DSL.table("Show"), DSL.field("screenId"), DSL.field("movieId"), DSL.field("showTime"))
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
}
