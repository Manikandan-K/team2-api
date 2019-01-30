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

        return dsl.select(DSL.field("public.\"Show\".\"id\"").as("id"),
                DSL.field("public.\"Movie\".\"name\"").as("movieName"),
                DSL.field("public.\"Movie\".\"experiences\"").as("experiences"),
                DSL.field("public.\"Screen\".\"name\"").as("screenName"),
                DSL.field("public.\"Show\".\"showTime\"").as("showTime"),
                DSL.field("public.\"Screen\".\"capacity\"").as("capacity"))
                .from(DSL.table("public.\"Show\""))
                .leftOuterJoin(DSL.table("public.\"Screen\""))
                .on(DSL.field("public.\"Show\".\"screenId\"").eq(DSL.field("public.\"Screen\".\"id\"")))

                .leftOuterJoin(DSL.table("public.\"Movie\""))
                .on(DSL.field("public.\"Show\".\"movieId\"").eq(DSL.field("public.\"Movie\".\"id\"")))

                .where("\"movieId\" = " + movieId)
                .and("\"locationId\" = "+ location)
                .and("\"showTime\" >= '"+ showDate +"'::date")
                .and("\"showTime\" < ('"+ showDate +"'::date + '1 day'::interval)")
                .fetchInto(ShowVO.class);

    }
}
