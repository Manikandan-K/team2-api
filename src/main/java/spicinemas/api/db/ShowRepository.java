package spicinemas.api.db;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ShowRepository {

    @Autowired
    private DSLContext dsl;

    public List getDistinctMovieIdsByLocation(long locationId) {

        String query = "select public.\"Show\".\"movieId\" from public.\"Show\" join public.\"Screen\" on public.\"Show\".\"screenId\" = public.\"Screen\".id where public.\"Screen\".\"locationId\" ="+locationId;
        List records = dsl.fetch(query).getValues(0);
        return records;

    }
}
