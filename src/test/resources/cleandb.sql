delete from user;
delete from book;
delete from user_role;
delete from list;
delete from user_book_data;
Insert into user (id, username, password) values (1, 'notAdmin', 'notPassword');
INSERT INTO user VALUES (2,'me','password');
INSERT INTO user VALUES (3,'user','secure');
INSERT INTO user VALUES (4,'user2','password2');
INSERT INTO user VALUES (5,'encrypt','me');
insert into book (id, isbn_10, isbn_13, title, author)values (1, '125031318X', '9781250313188', 'Gideon the Ninth', 'Tamsyn Muir');
INSERT INTO book (id, isbn_10, isbn_13, title, author) values (2, '1781084491', '9781781084496', 'Ninefox Gambit', 'Yoon Ha Lee');
INSERT INTO book (id, isbn_10, isbn_13, title, author) values (3, '1781085374', '9781781085370', 'Raven Stratagem', 'Yoon Ha Lee');
insert into user_book_data (id, user_id, book_id) values (1, 2, 1);
insert into user_book_data (id, user_id, book_id) values (2, 1, 2);
insert into user_book_data (id, user_id, book_id) values (3, 1, 3);
insert into user_role (id, user_id, role)values (1,2,'administrator');
insert into user_role (id, user_id, role)values (2,1,'user');
insert into list values (1, 1, 'first list', 'this is the first list');
insert into list values (2, 2, 'second list', 'this is the second list');
insert into user_book_list values (1, 2);
insert into user_book_list values (1, 3);
insert into user_book_list values (2, 1);