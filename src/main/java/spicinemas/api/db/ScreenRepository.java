package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Screen;

@Repository
@Transactional
public class ScreenRepository {
    @Autowired
    private DSLContext dsl;

    public long addScreen(Screen screen) {
        return (long) dsl.insertInto(
                    DSL.table("Screen"),
                    DSL.field("name"), DSL.field("locationId"),
                    DSL.field("capacity"))
                .values(screen.getName(), screen.getLocationId(), screen.getCapacity())
                .returning(DSL.field("id"))
                .fetchOne()
                .get(DSL.field("id"));
    }
}
