-- SEQUENCE: public."Movie_id_seq"

-- DROP SEQUENCE public."Movie_id_seq";

CREATE SEQUENCE public."Movie_id_seq";

-- SEQUENCE: public.booking_id_seq

-- DROP SEQUENCE public.booking_id_seq;

CREATE SEQUENCE public.booking_id_seq;

-- SEQUENCE: public.language_id_seq

-- DROP SEQUENCE public.language_id_seq;

CREATE SEQUENCE public.language_id_seq;

-- SEQUENCE: public.location_id_seq

-- DROP SEQUENCE public.location_id_seq;

CREATE SEQUENCE public.location_id_seq;

-- SEQUENCE: public.screen_id_seq

-- DROP SEQUENCE public.screen_id_seq;

CREATE SEQUENCE public.screen_id_seq;

-- SEQUENCE: public.show_id_seq

-- DROP SEQUENCE public.show_id_seq;

CREATE SEQUENCE public.show_id_seq;

-- Creation of tables
---------------------------


-- Table: public."Language"

-- DROP TABLE public."Language";

CREATE TABLE public."Language"
(
    id bigint NOT NULL DEFAULT nextval('language_id_seq'::regclass),
    name character varying(128)[] COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Language_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


-- Table: public."Location"

-- DROP TABLE public."Location";

CREATE TABLE public."Location"
(
    id bigint NOT NULL DEFAULT nextval('location_id_seq'::regclass),
    city character varying(40)[] COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Location_pkey" PRIMARY KEY (id),
    CONSTRAINT unique_city UNIQUE (city)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


-- Table: public."Movie"

-- DROP TABLE public."Movie";

CREATE TABLE public."Movie"
(
    id bigint NOT NULL DEFAULT nextval('"Movie_id_seq"'::regclass),
    name character varying(128)[] COLLATE pg_catalog."default" NOT NULL,
    synopsis text COLLATE pg_catalog."default",
    runtime integer NOT NULL,
    experiences character varying(128)[] COLLATE pg_catalog."default",
    "releaseDate" date,
    "cast" character varying(128)[] COLLATE pg_catalog."default",
    crew character varying(128)[] COLLATE pg_catalog."default",
    "bannerImageUrl" character varying(512)[] COLLATE pg_catalog."default",
    "languageId" bigint NOT NULL,
    CONSTRAINT "Movie_pkey" PRIMARY KEY (id),
    CONSTRAINT movie_unique_id UNIQUE (id)
,
    CONSTRAINT movie_language_fk FOREIGN KEY ("languageId")
        REFERENCES public."Language" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


-- Table: public."Screen"

-- DROP TABLE public."Screen";

CREATE TABLE public."Screen"
(
    id bigint NOT NULL DEFAULT nextval('screen_id_seq'::regclass),
    name character varying(256)[] COLLATE pg_catalog."default" NOT NULL,
    capacity integer NOT NULL,
    "locationId" bigint NOT NULL,
    CONSTRAINT "Screens_pkey" PRIMARY KEY (id),
    CONSTRAINT unique_id UNIQUE (id)
,
    CONSTRAINT screen_location_fk FOREIGN KEY ("locationId")
        REFERENCES public."Location" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


-- Table: public."Show"

-- DROP TABLE public."Show";

CREATE TABLE public."Show"
(
    id bigint NOT NULL DEFAULT nextval('show_id_seq'::regclass),
    "screenId" bigint NOT NULL,
    "movieId" bigint NOT NULL,
    "showTime" timestamp without time zone,
    CONSTRAINT "Show_pkey" PRIMARY KEY (id),
    CONSTRAINT show_movie_fk FOREIGN KEY ("movieId")
        REFERENCES public."Movie" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT show_screen_fk FOREIGN KEY ("screenId")
        REFERENCES public."Screen" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


-- Table: public."Booking"

-- DROP TABLE public."Booking";

CREATE TABLE public."Booking"
(
    id bigint NOT NULL DEFAULT nextval('booking_id_seq'::regclass),
    "showId" bigint NOT NULL,
    "userEmail" character varying(100)[] COLLATE pg_catalog."default" NOT NULL,
    "userName" character varying(100)[] COLLATE pg_catalog."default" NOT NULL,
    created timestamp without time zone NOT NULL DEFAULT now(),
    CONSTRAINT "Booking_pkey" PRIMARY KEY (id),
    CONSTRAINT booking_unique_id UNIQUE (id)
,
    CONSTRAINT booking_show_fk FOREIGN KEY ("showId")
        REFERENCES public."Show" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;
