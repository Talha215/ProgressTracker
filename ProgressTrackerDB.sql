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
show_id INT, 
show_name VARCHAR(30),
show_status VARCHAR(10),
progress INT,
PRIMARY KEY(users_id)
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

