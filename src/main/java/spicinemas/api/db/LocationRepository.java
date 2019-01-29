package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spicinemas.api.model.Location;

import java.util.List;

@Component
public class LocationRepository {

    @Autowired
    private DSLContext dsl;

    public List<Location> getAllLocations() {
        return dsl.select()
                .from(DSL.table("public.\"Location\""))
                .fetchInto(Location.class);
    }

}
