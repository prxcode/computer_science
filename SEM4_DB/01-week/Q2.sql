use 2024A7PS0081Udb;

CREATE TABLE actors(
    aid INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL);
    
INSERT INTO actors VALUES 
(1, 'Charlie Chaplin'),
(2, 'Kumar Khanna'),
(3, 'Amit Shah'),
(4, 'Ravi Kumar');

SELECT * FROM actors;


CREATE TABLE movies(
    mid INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL);

INSERT INTO movies VALUES 
(101, 'Modern Times'),
(102, 'The Great Dictator'),
(103, 'Comedy Nights'),
(104, 'Silent Era');

SELECT * FROM movies;

CREATE TABLE actor_role (
    mid INT,
    aid INT,
    rolename VARCHAR(50),
    FOREIGN KEY (mid) REFERENCES movies(mid),
    FOREIGN KEY (aid) REFERENCES actors(aid));


INSERT INTO actor_role VALUES 
(101, 1, 'Worker'),
(101, 1, 'Singer'),      
(102, 1, 'Dictator'),
(103, 2, 'Comedian'),
(103, 3, 'Guest'),
(104, 1, 'Tramp');

SELECT * FROM actor_role;

    
-- List all movies in which Charlie Chaplin acted + number of roles in each movie
SELECT m.title, COUNT(ar.rolename) AS number_of_roles FROM actors a JOIN actor_role ar ON a.aid = ar.aid JOIN movies m ON ar.mid = m.mid WHERE a.name = 'Charlie Chaplin' GROUP BY m.title;







