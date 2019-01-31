INSERT INTO Language (name) values ('Tamil');

INSERT INTO Location (city) values ('Chennai');
INSERT INTO Location (city) values ('Trichy');
INSERT INTO Location (city) values ('Madurai');

INSERT INTO Movie (name, synopsis, runtime, experiences, releaseDate, movieCast, crew, bannerImageUrl, languageId) VALUES ('Kabali', NULL, 180, 'RDX, Dolby Atmos, SUB', '2019-01-10', NULL, NULL, NULL, 1);
INSERT INTO Movie (name, synopsis, runtime, experiences, releaseDate, movieCast, crew, bannerImageUrl, languageId) VALUES ('Banjo', NULL, 180, 'RDX 3D', '2019-01-10', NULL, NULL, NULL, 1);
INSERT INTO Movie (name, synopsis, runtime, experiences, releaseDate, movieCast, crew, bannerImageUrl, languageId) VALUES ('Suicide Squad', NULL, 180, 'Dolby Atmos, RDX 3D, SUB', '2019-01-10', NULL, NULL, NULL, 1);
INSERT INTO Movie (name, synopsis, runtime, experiences, releaseDate, movieCast, crew, bannerImageUrl, languageId) VALUES ('Namadhu', NULL, 180, 'RDX, SUB', '2019-01-10', NULL, NULL, NULL, 1);
INSERT INTO Movie (name, synopsis, runtime, experiences, releaseDate, movieCast, crew, bannerImageUrl, languageId) VALUES ('Pelli Chupulu', NULL, 180, 'RDX, SUB', '2019-02-10', NULL, NULL, NULL, 1);
INSERT INTO Movie (name, synopsis, runtime, experiences, releaseDate, movieCast, crew, bannerImageUrl, languageId) VALUES ('Pink', NULL, 180, 'RDX, SUB', '2019-02-10', NULL, NULL, NULL, 1);
INSERT INTO Movie (name, synopsis, runtime, experiences, releaseDate, movieCast, crew, bannerImageUrl, languageId) VALUES ('Remo', NULL, 180, 'Dolby Atmos, RDX, SUB', '2019-02-10', NULL, NULL, NULL, 1);
INSERT INTO Movie (name, synopsis, runtime, experiences, releaseDate, movieCast, crew, bannerImageUrl, languageId) VALUES ('Inferno', NULL, 180, 'Dolby Atmos, RDX, SUB', '2019-02-10', NULL, NULL, NULL, 1);

INSERT INTO Screen (name, locationId, capacity) VALUES ('Chennai Screen 1', 1, 50);
INSERT INTO Screen (name, locationId, capacity) values ('PVR Chennai', 1, 50);
INSERT INTO Screen (name, locationId, capacity) values ('PVR Chennai IMAX', 1, 50);
INSERT INTO Screen (name, locationId, capacity) values ('PVR Trichy', 2, 50);
INSERT INTO Screen (name, locationId, capacity) values ('INOX Madhurai', 3, 50);
INSERT INTO Screen (name, locationId, capacity) values ('INOX Tricy', 2, 50);

INSERT INTO Show (screenId, movieId, showTime) VALUES (1, 5, '2019-01-31 17:30:00');
INSERT INTO Show (screenId, movieId, showTime) values (1, 2, '2019-02-02 14:00:00');
INSERT INTO Show (screenId, movieId, showTime) values (1, 2, '2019-02-02 20:00:00');
INSERT INTO Show (screenId, movieId, showTime) values (1, 2, '2019-02-03 14:00:00');
INSERT INTO Show (screenId, movieId, showTime) values (2, 3, '2019-02-02 16:00:00');
INSERT INTO Show (screenId, movieId, showTime) values (2, 3, '2019-02-02 22:00:00');
INSERT INTO Show (screenId, movieId, showTime) values (2, 3, '2019-02-03 18:00:00');
