package spicinemas.api.db;

import org.jooq.*;
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
//        return (long) dsl.insertInto(DSL.table("public.Language"),
//                    DSL.field("name"))
//                .values(language.getName())
//                .returning(DSL.field("id"))
//                .fetchOne()
//                .get(DSL.field("id"));
        Table<Record> languageTable = DSL.table("\"Language\"");
        InsertSetStep<Record> insertion = dsl.insertInto(languageTable);
        InsertValuesStep1<Record, Object> cols = insertion.columns(DSL.field("name"));
        InsertValuesStep1<Record, Object> result = cols.values(language.getName());
        Record record = result.returning(DSL.field("id")).fetchOne();
        Object id = record.get(DSL.field("id"));
        return (long) id;
    }

    public Language getLanguageByName(String name) {
        Record record = dsl.select(DSL.table("public.\"Language\"").field("name"))
                .from(DSL.table("public.\"Language\""))
                .where(DSL.field("name").eq(name))
                .fetchOne();
        return record.into(Language.class);
    }
}
