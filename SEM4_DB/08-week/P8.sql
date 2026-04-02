CREATE DATABASE ExamDB;
USE ExamDB;

# DROP DATABASE IF EXISTS ExamDB;
# Create the initial unnormalized table
CREATE TABLE Results (
    student_id INT,
    subject_id INT,
    student_name VARCHAR(50),
    subject_name VARCHAR(50),
    max_marks INT,
    obtained_marks INT
);

INSERT INTO Results VALUES 
(101, 1, 'Arjun', 'Mathematics', 100, 85), 
(101, 2, 'Arjun', 'Physics', 100, 78), 
(101, 3, 'Arjun', 'Chemistry', 100, 92),
(102, 1, 'Ishaan', 'Mathematics', 100, 70), 
(102, 2, 'Ishaan', 'Physics', 100, 65), 
(102, 4, 'Ishaan', 'Biology', 100, 88),
(103, 1, 'Aarav', 'Mathematics', 100, 95), 
(103, 3, 'Aarav', 'Chemistry', 100, 88), 
(103, 5, 'Aarav', 'History', 100, 90),
(104, 2, 'Vihaan', 'Physics', 100, 82), 
(104, 4, 'Vihaan', 'Biology', 100, 91), 
(104, 1, 'Vihaan', 'Mathematics', 100, 76),
(105, 1, 'Rohan', 'Mathematics', 100, 60), 
(105, 5, 'Rohan', 'History', 100, 75), 
(105, 2, 'Rohan', 'Physics', 100, 68),
(106, 2, 'Aryan', 'Physics', 100, 88), 
(106, 3, 'Aryan', 'Chemistry', 100, 72), 
(106, 4, 'Aryan', 'Biology', 100, 81),
(107, 3, 'Kabir', 'Chemistry', 100, 74), 
(107, 4, 'Kabir', 'Biology', 100, 80), 
(107, 5, 'Kabir', 'History', 100, 88),
(108, 4, 'Advait', 'Biology', 100, 96), 
(108, 5, 'Advait', 'History', 100, 85), 
(108, 1, 'Advait', 'Mathematics', 100, 89),
(109, 5, 'Reyansh', 'History', 100, 82), 
(109, 1, 'Reyansh', 'Mathematics', 100, 77), 
(109, 2, 'Reyansh', 'Physics', 100, 70),
(110, 1, 'Kiaan', 'Mathematics', 100, 77), 
(110, 2, 'Kiaan', 'Physics', 100, 89), 
(110, 3, 'Kiaan', 'Chemistry', 100, 94);


SELECT * FROM Results;

-- Create normalized Students table
CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(50)
);

#normalized Subjects table
CREATE TABLE Subjects (
    subject_id INT PRIMARY KEY,
    subject_name VARCHAR(50),
    max_marks INT
);


CREATE TABLE Results_2NF (
    student_id INT,
    subject_id INT,
    obtained_marks INT,
    PRIMARY KEY (student_id, subject_id),
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (subject_id) REFERENCES Subjects(subject_id)
);

-- Students table avoiding duplicates
INSERT INTO Students (student_id, student_name)
SELECT DISTINCT student_id, student_name FROM Results;

-- Subjects table avoiding duplicates
INSERT INTO Subjects (subject_id, subject_name, max_marks)
SELECT DISTINCT subject_id, subject_name, max_marks FROM Results;

-- Populate Results_2NF table avoiding duplicates
INSERT INTO Results_2NF (student_id, subject_id, obtained_marks)
SELECT DISTINCT student_id, subject_id, obtained_marks FROM Results;


SELECT * FROM Students;
SELECT * FROM Subjects;
SELECT * FROM Results_2NF;










CREATE TABLE Subjects_Info (
    subject_id INT,
    subject_name VARCHAR(50),
    dept_id INT,
    dept_name VARCHAR(50),
    dept_head VARCHAR(50)
);

INSERT INTO Subjects_Info VALUES 
(1,'Math',10,'Science','Dr. Sharma'),
(2,'Physics',10,'Science','Dr. Sharma'),
(3,'Chem',10,'Science','Dr. Sharma'),
(4,'Bio',10,'Science','Dr. Sharma'),
(5,'Hist',20,'Arts','Dr. Verma'),
(6,'Geo',20,'Arts','Dr. Verma'),
(7,'Soc',20,'Arts','Dr. Verma'),
(8,'Econ',30,'Commerce','Dr. Gupta'),
(9,'Acc',30,'Commerce','Dr. Gupta'),
(10,'Bus',30,'Commerce','Dr. Gupta'),
(11,'CS',40,'Engineering','Dr. Reddy'),
(12,'Mech',40,'Engineering','Dr. Reddy'),
(13,'Civil',40,'Engineering','Dr. Reddy'),
(14,'Elec',40,'Engineering','Dr. Reddy'),
(15,'Eng',50,'Languages','Dr. Iyer'),
(16,'Hindi',50,'Languages','Dr. Iyer'),
(17,'Tamil',50,'Languages','Dr. Iyer'),
(18,'Sanskrit',50,'Languages','Dr. Iyer'),
(19,'PolSc',20,'Arts','Dr. Verma'),
(20,'Phil',20,'Arts','Dr. Verma'),
(21,'Stats',10,'Science','Dr. Sharma'),
(22,'Gen',10,'Science','Dr. Sharma'),
(23,'Micro',10,'Science','Dr. Sharma'),
(24,'Mark',30,'Commerce','Dr. Gupta'),
(25,'Fin',30,'Commerce','Dr. Gupta'),
(26,'Robo',40,'Engineering','Dr. Reddy'),
(27,'Data',40,'Engineering','Dr. Reddy'),
(28,'Urdu',50,'Languages','Dr. Iyer'),
(29,'Psy',20,'Arts','Dr. Verma'),
(30,'Ast',10,'Science','Dr. Sharma');


-- Departments table for 3NF
CREATE TABLE Departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50),
    dept_head VARCHAR(50)
);

-- Subjects_3NF table linked to Departments
CREATE TABLE Subjects_3NF (
    subject_id INT PRIMARY KEY,
    subject_name VARCHAR(50),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES Departments(dept_id)
);

-- Departments table avoiding duplicates
INSERT INTO Departments (dept_id, dept_name, dept_head)
SELECT DISTINCT dept_id, dept_name, dept_head FROM Subjects_Info;

-- Subjects_3NF table avoiding duplicates
INSERT INTO Subjects_3NF (subject_id, subject_name, dept_id)
SELECT DISTINCT subject_id, subject_name, dept_id FROM Subjects_Info;


SELECT * FROM Departments;
SELECT * FROM Subjects_3NF;
