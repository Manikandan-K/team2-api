package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Movie;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
@Transactional
public class MovieRepository {
    @Autowired
    private DSLContext dsl;

    public List<Movie> getNowShowingMovies(Long[] languages) {
        String now = LocalDate.now().toString();
        return dsl.select(DSL.field("name"),DSL.field("releaseDate"))
                .from(DSL.table("Movie"))
                .where("releaseDate <= '"+now+"'::date")
                .and(DSL.field("languageId").in(DSL.list(Arrays.stream(languages).map(DSL::val).collect(toList()))))
                .fetchInto(Movie.class);
    }


    public List<Movie> getNowShowingMoviesByIdsAndLanguageIds(Long[] languages,Long[] movieIds) {
        String now = LocalDate.now().toString();
        return dsl.select(DSL.field("name"),DSL.field("releaseDate"))
                .from(DSL.table("Movie"))
                .where("releaseDate <= '"+now+"'::date")
                .and(DSL.field("languageId").in(DSL.list(Arrays.stream(languages).map(DSL::val).collect(toList()))))
                .and(DSL.field("id").in(DSL.list(Arrays.stream(movieIds).map(DSL::val).collect(toList()))))
                .fetchInto(Movie.class);
    }

    public List<Movie> getUpcomingMoviesByIdsAndLanguageIds(Long[] languages,Long[] movieIds) {
        String now = LocalDate.now().toString();
        return dsl.select(DSL.field("name"),DSL.field("releaseDate"))
                .from(DSL.table("Movie"))
                .where("releaseDate > '"+now+"'::date")
                .and(DSL.field("languageId").in(DSL.list(Arrays.stream(languages).map(DSL::val).collect(toList()))))
                .and(DSL.field("id").in(DSL.list(Arrays.stream(movieIds).map(DSL::val).collect(toList()))))
                .fetchInto(Movie.class);
    }




    public List<Movie> geUpcomingMovies(long[] languages) {
        String now = LocalDate.now().toString();
        return dsl.select(DSL.field("name"), DSL.field("releaseDate"))
                .from(DSL.table("Movie"))
                .where("releaseDate > '" + now + "'::date")
                .fetchInto(Movie.class);
    }

    public long addMovie(Movie movie) {
        return (long) dsl.insertInto(DSL.table("Movie"), DSL.field("name"), DSL.field("experiences"), DSL.field("releaseDate"),
                    DSL.field("synopsis"), DSL.field("runTime"), DSL.field("movieCast"), DSL.field("crew"), DSL.field("bannerImageUrl"), DSL.field("languageId"))
                    .values(movie.getName(), movie.getExperiences(), movie.getReleaseDate(),
                            movie.getSynopsis(), movie.getRunTime(), movie.getCast(), movie.getCrew(),
                            movie.getBannerImageUrl(), movie.getLanguageId())
                    .returning(DSL.field("id"))
                    .fetchOne()
                    .get(DSL.field("id"));
    }

    public Movie getMovie(String name) {
        return dsl.select(DSL.field("name"))
                .from(DSL.table("Movie"))
                .where(DSL.field("name").eq(name))
                .fetchOne()
                .into(Movie.class);
    }

    public Movie getMovieById(int id) {
        return dsl.select()
                .from(DSL.table("Movie"))
                .where(DSL.field("Movie.id").eq(id))
                .fetchOne()
                .into(Movie.class);
    }
}
