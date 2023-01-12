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
primary key(users_id)
);


