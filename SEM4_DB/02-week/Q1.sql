use 2024A7PS0081Udb;

CREATE TABLE STUDENT(
student_id INT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
department VARCHAR(30));

INSERT INTO STUDENT VALUES 
    (12345, 'Rahul', 'CS'),
    (23456, 'Aditi', 'ME'),
    (34567, 'Kumar', 'EC');
    SELECT * FROM STUDENT; -- TO view the result run this cmd, use cmd + shift + enter to run this line only
	

CREATE TABLE COURSE(
course_id INT PRIMARY KEY,
title VARCHAR(100) NOT NULL,
credits INT);

INSERT INTO COURSE VALUES 
    (101, 'Database', 4),
    (102, 'Data Structure', 3),
    (103, 'Operating System', 4);
    SELECT * FROM COURSE; 
    
CREATE TABLE REGISTRATION (
student_id INT,
course_id INT,
semester VARCHAR(10),
FOREIGN KEY (student_id) REFERENCES STUDENT (student_id),
FOREIGN KEY (course_id) REFERENCES COURSE (course_id));

INSERT INTO REGISTRATION VALUES 
    (12345, 101, 'S1'),
    (12345, 102, 'S1'),
    (23456, 101, 'S1');
    SELECT * FROM REGISTRATION; 
    
    
SELECT * FROM STUDENT;
