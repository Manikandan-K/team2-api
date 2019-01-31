package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
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

    public long addLanguage(Language language) {
        return (long)dsl.insertInto(DSL.table("Language"))
                .columns(DSL.field("name"))
                .values(language.getName())
                .returning(DSL.field("id"))
                .fetchOne()
                .get(DSL.field("id"));
    }

    public Language getLanguageByName(String name) {
        SelectConditionStep<Record> whereClause = dsl.select()
                .from(DSL.table("Language"))
                .where(DSL.field("name").eq(name));
        return whereClause.fetchOne()
                .into(Language.class);
    }
}
