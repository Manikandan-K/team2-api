package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Movie;

import java.util.List;

@Repository
@Transactional
public class MovieRepository {
    @Autowired
    private DSLContext dsl;

    public List<Movie> getNowShowingMovies(String type, String location, String languages) {
        return dsl.select()
                .from(DSL.table("Movie"))
                .where(DSL.field("Movie.locationId").eq(type))
                .fetchInto(Movie.class);
    }

    public void addMovie(Movie movie) {
        dsl.insertInto(DSL.table("MOVIE"), DSL.field("NAME"), DSL.field("EXPERIENCES"), DSL.field("LISTING_TYPE"))
                .values(movie.getName(), movie.getExperiences(), movie.getListingType().toString())
                .execute();

    }

    public Movie getMovie(String name) {
        return dsl.select(DSL.field("NAME"), DSL.field("EXPERIENCES"), DSL.field("LISTING_TYPE"))
                .from(DSL.table("MOVIE"))
                .where(DSL.field("MOVIE.NAME").eq(name))
                .fetchOne()
                .into(Movie.class);
    }

}
