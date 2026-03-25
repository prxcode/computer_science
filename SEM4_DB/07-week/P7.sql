DROP DATABASE IF EXISTS MovieDB;
CREATE DATABASE MovieDB;
USE MovieDB;

CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE Movies (
    movie_id INT PRIMARY KEY,
    movie_name VARCHAR(50)
);


CREATE TABLE Bookings (
    booking_id INT PRIMARY KEY,
    user_id INT,
    movie_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id)
);


# for 1NF Conversion

#reset database
DROP DATABASE IF EXISTS MovieDB;
CREATE DATABASE MovieDB;
USE MovieDB;


CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    name VARCHAR(50)
) ENGINE=InnoDB;

CREATE TABLE Movies (
    movie_id INT PRIMARY KEY,
    movie_name VARCHAR(50)
) ENGINE=InnoDB;


CREATE TABLE Bookings (
    booking_id INT PRIMARY KEY,
    user_id INT,
    movie_ids VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
) ENGINE=InnoDB;


INSERT INTO Users VALUES
(101, 'Alice'),
(102, 'Bob'),
(103, 'John'),
(104, 'Sarah'),
(105, 'Michael'),
(106, 'Emily');

INSERT INTO Movies VALUES
(1, 'Avengers'),
(2, 'Batman'),
(3, 'Spiderman'),
(4, 'Superman'),
(5, 'Inception'),
(6, 'The Dark Knight'),
(7, 'Avatar'),
(8, 'Joker');

#inserting values as csv
INSERT INTO Bookings VALUES
(1, 101, '1,2,3'),
(2, 102, '2,4'),
(3, 103, '5,6,7'),
(4, 104, '1,8'),
(5, 105, '3,4,8'),
(6, 106, '6,7');

#to create helper Numbers table (for splitting)
CREATE TABLE Numbers (n INT);
INSERT INTO Numbers VALUES (1),(2),(3),(4),(5);

CREATE TABLE Movies_1 (
    booking_id INT,
    user_id INT,
    movie_id INT,
    FOREIGN KEY (booking_id) REFERENCES Bookings(booking_id),
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id)
) ENGINE=InnoDB;


INSERT INTO Movies_1 (booking_id, user_id, movie_id)
SELECT 
    b.booking_id,
    b.user_id,
    CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(b.movie_ids, ',', n), ',', -1) AS UNSIGNED)
FROM Bookings b
JOIN Numbers 
ON n <= 1 + LENGTH(b.movie_ids) - LENGTH(REPLACE(b.movie_ids, ',', ''));


SELECT * FROM Movies_1;
