USE 2024A7PS0081Udb;
CREATE TABLE Student(
	sid INT PRIMARY KEY,
    name VARCHAR(30),
    dept VARCHAR(20),
	year DATE);
    
    INSERT INTO Student VALUES 
    (101, 'Pankaj', 'Computer Science', 2024-05-04),
    (102, 'Rahul', 'ECE', 2025-07-24),
    (103, 'Sanjay', 'Biotech', 2024-04-30),
    (104, 'Rakesh', 'Computer Science', 2024-05-04),
    (105, 'Sam', 'Mechanical', 2025-07-24),
    (106, 'Pratham', 'Biotech', 2026-04-30),
    (107, 'Suryansh', 'Computer Science', 2024-05-04),
    (108, 'Suraj', 'Mechanical', 2025-07-24),
    (109, 'Ankit', 'Biotech', 2026-04-30),
    (110, 'Abhinav', 'Computer Science', 2026-05-04),
    (111, 'Abhijeet', 'ECE', 2024-07-24),
    (112, 'Soorya', 'Biotech', 2024-04-30);
    

CREATE TABLE Enroll(
	sid INT PRIMARY KEY,
    cid INT PRIMARY KEY,
    semester INT,
	grade INT);
    
    INSERT INTO Enroll VALUES 
    (101, 301, 3, 89),
    (102, 302, 1, 90),
    (103, 303, 2, 77),
    (104, 304, 3, 85),
    (105, 305, 1, 93),
    (106, 306, 3, 82),
    (107, 307, 1, 97),
    (108, 308, 2, 85),
    (109, 309, 5, 94),
    (110, 310, 3, 83),
    (111, 311, 1, 68),
    (112, 312, 6, 74),
    (113, 313, 8, 72),
    (114, 314, 4, 81),
    (115, 315, 2, 79),
    (116, 316, 1, 88),
    (117, 317, 2, 72),
    (118, 318, 1, 66),
    (119, 319, 1, 67),
    (120, 320, 1, 60),
    (121, 321, 1, 74),
    (122, 322, 1, 93);
    
   
CREATE TABLE Course(
	cid INT PRIMARY KEY,
    title VARCHAR(30),
    dept VARCHAR(20),
	credits INT);
    
    INSERT INTO Course VALUES 
    (302, 'Database', 'Computer Science', 32),
    (303, 'DSA', 'Computer Science', 43),
    (301, 'MPI', 'ECE', 44),
    (304, 'Biology', 'Biotech', 56),
    (305, 'EG', 'Mechanical', 47);
    
    
    -- Q1. Retrive Name of CSE Students and titles of CSE Courses taken in fall 2024.
    -- Q2. Use two of these SQL queries 1. Query 1 (JOIN FIRST APPROACH) 2. Selection FIRST APPROACH using subqueries
    -- Q3. For each query stundets must determine, 1. number of attributes a) after each join b) in the final result, 2. number of rows a) after each join step USE SELECT COUNT(*) on intermediate joins
    -- Q4. Answer VIVA 1. which query produced smaller intermediates results? 2. Which join order is more efficient? 3. Why does applying selections before joins help?
    
    
    
