package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Language;

@Repository
@Transactional
public class LanguageRepository {
    @Autowired
    private DSLContext dsl;

    public Language getLanguageByName(String name) {
        return dsl.select(DSL.field("name"))
                .from(DSL.table("Language"))
                .where(DSL.field("Language.name").eq(name))
                .fetchOne()
                .into(Language.class);
    }
}
