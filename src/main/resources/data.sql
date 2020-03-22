INSERT INTO CLIENT (client_id, name, surname, type_of_ticket) VALUES (1, 'Robert', 'Jordan', 'Adult');
INSERT INTO CLIENT (client_id, name, surname, type_of_ticket) VALUES (2, 'Ernest', 'Hemingway', 'Adult');
INSERT INTO CLIENT (client_id, name, surname, type_of_ticket) VALUES (3, 'Pippi', 'Longstocking', 'Children');
INSERT INTO CLIENT (client_id, name, surname, type_of_ticket) VALUES (4, 'Holden', 'Caulfield', 'Student');
INSERT INTO CLIENT (client_id, name, surname, type_of_ticket) VALUES (5, 'Moema', 'von Wogau', 'Student');

INSERT INTO MOVIE (movie_id,name,running_time) VALUES (1, 'Forrest Gump',144);
INSERT INTO MOVIE (movie_id,name,running_time) VALUES (2, 'Se7en',127);
INSERT INTO MOVIE (movie_id,name,running_time) VALUES (3, 'The Silence of the Lambs',118);
INSERT INTO MOVIE (movie_id,name,running_time) VALUES (4, 'The Shawshank Redemption',144);
INSERT INTO MOVIE (movie_id,name,running_time) VALUES (5, 'A Beautiful Mind',135);

INSERT INTO SCREENING (screening_id, start_time, movie_id) VALUES (1, "2020-03-28T15:00:00", 1);
INSERT INTO SCREENING (screening_id, start_time, movie_id) VALUES (2, "2020-03-28T15:00:00", 3);

INSERT INTO procurement (procurement_id,procurement_time, total_price, client_id) VALUES (1,"2020-03-21T15:00:00",10,1);
INSERT INTO SEAT (seat_id, seat_number,number_of_row,screening_room_number,procurement_id, screening_id) VALUES (1,5,10,3,1,1);