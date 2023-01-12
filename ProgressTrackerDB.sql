drop database if exists progressTracker;
CREATE DATABASE progressTracker;
use progressTracker;

CREATE TABLE tvshows (
tvshows_id INT AUTO_INCREMENT,
tvshow_name VARCHAR(30),
PRIMARY KEY (tvshows_id)
);

CREATE TABLE login (
login_id INT AUTO_INCREMENT,
user_name VARCHAR(30),
passcode VARCHAR(20),
PRIMARY KEY (login_id)
);

CREATE TABLE users (
users_id INT auto_increment,
tvshows_id INT,
login_id INT,
show_id INT, 
show_name VARCHAR(30),
show_status VARCHAR(15),
progress INT,
PRIMARY KEY(users_id),
FOREIGN KEY (tvshows_id) references tvshows(tvshows_id),
FOREIGN KEY (login_id) references login(login_id)
);

insert into login (login_id, user_name, passcode) values(null, 'user1', 'password1');
insert into login (login_id, user_name, passcode) values(null, 'user2', 'password2');

insert into tvshows (tvshows_id, tvshow_name) values (null, 'Sopranos');
insert into tvshows (tvshows_id, tvshow_name) values (null, 'Seinfield');
insert into tvshows (tvshows_id, tvshow_name) values (null, 'The Twilight Zone');
insert into tvshows (tvshows_id, tvshow_name) values (null, 'All in the Family');
insert into tvshows (tvshows_id, tvshow_name) values (null, 'M*A*S*H');
insert into tvshows (tvshows_id, tvshow_name) values (null, 'The Mary Tyler Moore Show');
insert into tvshows (tvshows_id, tvshow_name) values (null, 'Mad Men');
insert into tvshows (tvshows_id, tvshow_name) values (null, 'Cheers');
insert into tvshows (tvshows_id, tvshow_name) values (null, 'The Wire');
insert into tvshows (tvshows_id, tvshow_name) values (null, 'The West Wing');

insert into users (login_id, tvshows_id, show_name, show_status, progress) values 
(1, null, 'The West Wing', 'in-progress', 50);
insert into users (login_id, tvshows_id, show_name, show_status, progress) values 
(1, null, 'Seinfield', 'not completed', 0);
insert into users (login_id, tvshows_id, show_name, show_status, progress) values 
(2, null, 'Mad Men', 'completed', 100);
insert into users (login_id, tvshows_id, show_name, show_status, progress) values 
(2, null, 'The Wire', 'not completed', 0);

