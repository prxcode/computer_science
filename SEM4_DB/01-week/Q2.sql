use 2024A7PS0081Udb;

CREATE TABLE actors(
    aid INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL);
    
INSERT INTO actors VALUES 
(1, 'Charlie Chaplin'),
(2, 'Kumar Khanna'),
(3, 'Amitabh Bacchan'),
(4, 'Shah Rukh Khan');

SELECT * FROM actors;


CREATE TABLE movies(
    mid INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL);

INSERT INTO movies VALUES 
(101, 'Modern Times'),
(102, 'The Great Dictator'),
(103, 'Sholay'),
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
(103, 3, 'Side Actor'),
(104, 1, 'Dancer');

SELECT * FROM actor_role;

    
-- List all movies in which Charlie Chaplin acted + number of roles in each movie
SELECT m.title, COUNT(ar.rolename) AS number_of_roles FROM actors a JOIN actor_role ar ON a.aid = ar.aid JOIN movies m ON ar.mid = m.mid WHERE a.name = 'Charlie Chaplin' GROUP BY m.title;



Your table creation, inserts, and the first query are **correct** for the given question. ✅
Now let’s write the second required query.

---

## ✅ 1) Movies in which *Charlie Chaplin* acted + number of roles

(You already wrote this correctly)

```sql
SELECT m.title, COUNT(ar.rolename) AS number_of_roles
FROM actors a
JOIN actor_role ar ON a.aid = ar.aid
JOIN movies m ON ar.mid = m.mid
WHERE a.name = 'Charlie Chaplin'
GROUP BY m.title;
```

✔ This works because:

* We join all three tables
* Filter only Charlie Chaplin
* Group by movie title
* Count number of roles per movie

---

## ✅ 2) List names of actors along with titles of movies they have acted in

**If they have not acted in any movie, show movie title as NULL**

For this requirement, we must use **LEFT JOIN**.

```sql
SELECT a.name, m.title
FROM actors a
LEFT JOIN actor_role ar ON a.aid = ar.aid
LEFT JOIN movies m ON ar.mid = m.mid;
```

---

### 🔎 Why LEFT JOIN?

* LEFT JOIN ensures **all actors are shown**
* If an actor has no movie:

  * `actor_role` will be NULL
  * `movie title` will automatically show NULL

If we used INNER JOIN, actors without movies would NOT appear.

---

## ✅ Final Result Explanation

| Query        | Purpose                                  |
| ------------ | ---------------------------------------- |
| First Query  | Charlie Chaplin movies + number of roles |
| Second Query | All actors + their movies (NULL if none) |

---

If you'd like, I can also show you how the output tables would look based on your inserted data.

