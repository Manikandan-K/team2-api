-- SEQUENCE: Movie_id_seq

-- DROP SEQUENCE Movie_id_seq;

CREATE SEQUENCE Movie_id_seq;

-- SEQUENCE: booking_id_seq

-- DROP SEQUENCE booking_id_seq;

CREATE SEQUENCE booking_id_seq;

-- SEQUENCE: language_id_seq

-- DROP SEQUENCE language_id_seq;

CREATE SEQUENCE language_id_seq;

-- SEQUENCE: location_id_seq

-- DROP SEQUENCE location_id_seq;

CREATE SEQUENCE location_id_seq;

-- SEQUENCE: screen_id_seq

-- DROP SEQUENCE screen_id_seq;

CREATE SEQUENCE screen_id_seq;

-- SEQUENCE: show_id_seq

-- DROP SEQUENCE show_id_seq;

CREATE SEQUENCE show_id_seq;

-- Creation of tables
---------------------------


-- Table: Language

-- DROP TABLE Language;

CREATE TABLE Language
(
    id bigint NOT NULL DEFAULT nextval('language_id_seq'),
    name varchar(128) NOT NULL,
    CONSTRAINT Language_pkey PRIMARY KEY (id)
);

-- Table: Location

-- DROP TABLE Location;

CREATE TABLE Location
(
    id bigint NOT NULL DEFAULT nextval('location_id_seq'),
    city varchar(40) NOT NULL,
    CONSTRAINT Location_pkey PRIMARY KEY (id),
    CONSTRAINT unique_city UNIQUE (city)
);

-- Table: Movie

-- DROP TABLE Movie;

CREATE TABLE Movie
(
    id bigint NOT NULL DEFAULT nextval('Movie_id_seq'),
    name varchar(128) NOT NULL,
    synopsis text,
    runtime integer NOT NULL,
    experiences varchar(128),
    releaseDate date,
    crew varchar(128),
    movieCast varchar(128),
    bannerImageUrl varchar(512),
    languageId bigint NOT NULL,
    CONSTRAINT Movie_pkey PRIMARY KEY (id),
    CONSTRAINT movie_unique_id UNIQUE (id),
    CONSTRAINT movie_language_fk FOREIGN KEY (languageId)
        REFERENCES Language (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


-- Table: Screen

-- DROP TABLE Screen;

CREATE TABLE Screen
(
    id bigint NOT NULL DEFAULT nextval('screen_id_seq'),
    name varchar(256) NOT NULL,
    capacity integer NOT NULL,
    locationId bigint NOT NULL,
    CONSTRAINT Screens_pkey PRIMARY KEY (id),
    CONSTRAINT unique_id UNIQUE (id)
,
    CONSTRAINT screen_location_fk FOREIGN KEY (locationId)
        REFERENCES Location (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


-- Table: Show

-- DROP TABLE Show;

CREATE TABLE Show
(
    id bigint NOT NULL DEFAULT nextval('show_id_seq'),
    screenId bigint NOT NULL,
    movieId bigint NOT NULL,
    showTime timestamp without time zone,
    CONSTRAINT Show_pkey PRIMARY KEY (id),
    CONSTRAINT show_movie_fk FOREIGN KEY (movieId)
        REFERENCES Movie (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT show_screen_fk FOREIGN KEY (screenId)
        REFERENCES Screen (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


-- Table: Booking

-- DROP TABLE Booking;

CREATE TABLE Booking
(
    id bigint NOT NULL DEFAULT nextval('booking_id_seq'),
    showId bigint NOT NULL,
    userEmail varchar(100) NOT NULL,
    userName varchar(100) NOT NULL,
    created timestamp without time zone NOT NULL DEFAULT now(),
    CONSTRAINT Booking_pkey PRIMARY KEY (id),
    CONSTRAINT booking_unique_id UNIQUE (id),
    CONSTRAINT booking_show_fk FOREIGN KEY (showId)
        REFERENCES Show (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
