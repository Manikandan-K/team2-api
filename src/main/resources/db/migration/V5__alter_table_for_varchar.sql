ALTER TABLE public."Language"
    ALTER COLUMN name TYPE varchar(128) COLLATE pg_catalog."default";

ALTER TABLE public."Location"
    ALTER COLUMN city TYPE varchar(40) COLLATE pg_catalog."default";

ALTER TABLE public."Movie"
    ALTER COLUMN name TYPE varchar(128) COLLATE pg_catalog."default";

ALTER TABLE public."Movie"
    ALTER COLUMN experiences TYPE varchar(128) COLLATE pg_catalog."default";

ALTER TABLE public."Movie"
    ALTER COLUMN "cast" TYPE varchar(128) COLLATE pg_catalog."default";

ALTER TABLE public."Movie"
    ALTER COLUMN crew TYPE varchar(128) COLLATE pg_catalog."default";

ALTER TABLE public."Movie"
    ALTER COLUMN "bannerImageUrl" TYPE varchar(512) COLLATE pg_catalog."default";

ALTER TABLE public."Screen"
    ALTER COLUMN name TYPE varchar(256) COLLATE pg_catalog."default";

ALTER TABLE public."Booking"
    ALTER COLUMN "userEmail" TYPE varchar(256) COLLATE pg_catalog."default";

ALTER TABLE public."Booking"
    ALTER COLUMN "userName" TYPE varchar(256) COLLATE pg_catalog."default";
