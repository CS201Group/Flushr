DROP DATABASE IF EXISTS Flushr_DB;

CREATE DATABASE Flushr_DB;

USE Flushr_DB;


CREATE TABLE Bathroom(
    bathroom_id VARCHAR(255) NOT NULL,
    bathroom_location VARCHAR(255),

    PRIMARY KEY(bathroom_id)
);

CREATE TABLE Rating(
    rating_id VARCHAR(255) NOT NULL,
    bathroom_id VARCHAR(255) NOT NULL,
    overall_rating INT,
    cleanliness INT,
    accessibility INT,
    wait_time INT,

    PRIMARY KEY(rating_id),
    FOREIGN KEY (bathroom_id) REFERENCES  Bathroom(bathroom_id)
);


CREATE TABLE User(
	user_id VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    
    PRIMARY KEY(user_id)
);

-- bridge table
CREATE TABLE bathroom_bookmarks(
    bathroom_id VARCHAR(255) NOT NULL,
	user_id VARCHAR(255) NOT NULL,
    
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (bathroom_id) REFERENCES  Bathroom(bathroom_id)
);

