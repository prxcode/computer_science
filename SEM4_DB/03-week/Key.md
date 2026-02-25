Below are **complete SQL queries** for all 4 requirements exactly as asked.

---

# ✅ Q1. Retrieve Names of CSE Students and Titles of CSE Courses taken in Fall 2024

## ✔ Query 1 – JOIN FIRST APPROACH

```sql
-- Step 1: Join Student and Enroll
SELECT *
FROM Student S
JOIN Enroll E ON S.sid = E.sid;

-- Count rows after first join
SELECT COUNT(*) AS count_after_first_join
FROM Student S
JOIN Enroll E ON S.sid = E.sid;

-- Step 2: Join with Course
SELECT *
FROM Student S
JOIN Enroll E ON S.sid = E.sid
JOIN Course C ON E.cid = C.cid;

-- Count rows after second join
SELECT COUNT(*) AS count_after_second_join
FROM Student S
JOIN Enroll E ON S.sid = E.sid
JOIN Course C ON E.cid = C.cid;

-- Final Result
SELECT S.name, C.title
FROM Student S
JOIN Enroll E ON S.sid = E.sid
JOIN Course C ON E.cid = C.cid
WHERE S.dept = 'Computer Science'
AND C.dept = 'Computer Science'
AND YEAR(S.year) = 2024;
```

---

## ✔ Query 2 – SELECTION FIRST APPROACH (Using Subqueries)

```sql
-- Step 1: Filter Students first
SELECT *
FROM Student
WHERE dept = 'Computer Science'
AND YEAR(year) = 2024;

-- Count filtered students
SELECT COUNT(*) AS filtered_students
FROM Student
WHERE dept = 'Computer Science'
AND YEAR(year) = 2024;

-- Step 2: Filter Courses first
SELECT *
FROM Course
WHERE dept = 'Computer Science';

-- Count filtered courses
SELECT COUNT(*) AS filtered_courses
FROM Course
WHERE dept = 'Computer Science';

-- Step 3: Join filtered tables
SELECT *
FROM
    (SELECT * FROM Student
     WHERE dept = 'Computer Science'
     AND YEAR(year) = 2024) S
JOIN Enroll E ON S.sid = E.sid;

-- Count after first join
SELECT COUNT(*) AS count_after_first_join
FROM
    (SELECT * FROM Student
     WHERE dept = 'Computer Science'
     AND YEAR(year) = 2024) S
JOIN Enroll E ON S.sid = E.sid;

-- Final Result
SELECT S.name, C.title
FROM
    (SELECT * FROM Student
     WHERE dept = 'Computer Science'
     AND YEAR(year) = 2024) S
JOIN Enroll E ON S.sid = E.sid
JOIN
    (SELECT * FROM Course
     WHERE dept = 'Computer Science') C
ON E.cid = C.cid;
```

---

# ✅ Q3. Number of Attributes

You can verify attributes using:

```sql
DESCRIBE Student;
DESCRIBE Enroll;
DESCRIBE Course;
```

After Join:

```sql
SELECT *
FROM Student S
JOIN Enroll E ON S.sid = E.sid
LIMIT 1;
```

Count attributes manually from output columns.

Final result attributes:

```sql
SELECT S.name, C.title
FROM Student S
JOIN Enroll E ON S.sid = E.sid
JOIN Course C ON E.cid = C.cid;
```

→ Only 2 attributes (`name`, `title`)

---

# ✅ Q4. VIVA ANSWERS

1️⃣ Smaller intermediate result → **Selection First Approach**

2️⃣ More efficient join order → **Apply selection before join**

3️⃣ Why?
Because filtering reduces number of tuples before performing costly join operations, which improves performance and reduces memory usage.

---

If you want, I can also compute exact row counts from your given data so you can directly write numbers in your assignment.
