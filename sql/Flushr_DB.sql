DROP DATABASE IF EXISTS Flushr_DB;

CREATE DATABASE Flushr_DB;

USE Flushr_DB;


CREATE TABLE Bathroom(
	bathroom_name VARCHAR(255) NOT NULL,
    bathroom_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    bathroom_location VARCHAR(255),
    image_url VARCHAR(255),

    PRIMARY KEY(bathroom_name)
);

CREATE TABLE Rating(
    rating_id INT NOT NULL AUTO_INCREMENT,
    bathroom_id INT NOT NULL,
    overall_rating DECIMAL(2,1),
    cleanliness DECIMAL(2,1),
    accessibility DECIMAL(2,1),
    wait_time DECIMAL(2,1),

    PRIMARY KEY(rating_id),
    FOREIGN KEY (bathroom_id) REFERENCES Bathroom(bathroom_id)
);

CREATE TABLE User(
	email VARCHAR(255) NOT NULL,
	user_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    name VARCHAR(255),
    password VARCHAR(255),
    
    PRIMARY KEY(email)
);


-- bridge table
CREATE TABLE bathroom_bookmarks(
    bathroom_id INT NOT NULL,
	user_id INT NOT NULL UNIQUE,
    
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (bathroom_id) REFERENCES  Bathroom(bathroom_id)
);

