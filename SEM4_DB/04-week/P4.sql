CREATE DATABASE IF NOT EXISTS db_lab_uni;
USE db_lab_uni;


CREATE TABLE DOCTOR (
    doctor_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    specialization VARCHAR(100)
);

INSERT INTO DOCTOR VALUES
(1, 'Dr. Smith', 'Cardiology'),
(2, 'Dr. Adams', 'Neurology'),
(3, 'Dr. Taylor', 'Pediatrics'),
(4, 'Dr. Brown', 'Dermatology'),
(5, 'Dr. Wilson', 'Oncology'),
(6, 'Dr. Miller', 'General Practice');

CREATE TABLE PATIENT (
    patient_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100)
);\

INSERT INTO PATIENT VALUES
(101, 'Alice Green', 'New York'),
(102, 'Bob White', 'Chicago'),
(103, 'Charlie Black', 'Boston'),
(104, 'Diana Prince', 'Seattle'),
(105, 'Edward Norton', 'Austin'),
(106, 'Fiona Glen', 'Miami'),
(107, 'George King', 'Denver'),
(108, 'Hannah Scott', 'Phoenix');

CREATE TABLE APPOINTMENT (
    appointment_id INT PRIMARY KEY,
    doctor_id INT,
    patient_id INT,
    visit_date DATE,
    FOREIGN KEY (doctor_id) REFERENCES DOCTOR(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES PATIENT(patient_id)
);

INSERT INTO APPOINTMENT VALUES
(1, 1, 101, '2024-01-10'),
(2, 2, 102, '2024-01-12'),
(3, 3, 103, '2024-01-15'),
(4, 4, 104, '2024-01-20'),
(5, 1, 105, '2024-02-01'),
(6, 2, 106, '2024-02-05');

-- 1. List all doctors and their patients (include doctors without appointments)
SELECT D.name AS Doctor_Name, P.name AS Patient_Name FROM DOCTOR D LEFT JOIN APPOINTMENT A ON D.doctor_id = A.doctor_id LEFT JOIN PATIENT P ON A.patient_id = P.patient_id;

-- 2. List all patients and their doctors (include patients without appointments)
SELECT P.name AS Patient_Name, D.name AS Doctor_Name FROM PATIENT P LEFT JOIN APPOINTMENT A ON P.patient_id = A.patient_id LEFT JOIN DOCTOR D ON A.doctor_id = D.doctor_id; 

-- 3. Show doctors who never treated any patient
SELECT D.name AS Doctor_With_No_Appointments FROM DOCTOR D LEFT JOIN APPOINTMENT A ON D.doctor_id = A.doctor_id WHERE A.appointment_id IS NULL;

-- 4. Show patients who never had an appointment
SELECT P.name AS Patient_With_No_Appointments FROM PATIENT P LEFT JOIN APPOINTMENT A ON P.patient_id = A.patient_id WHERE A.appointment_id IS NULL;

-- 5. Write a NATURAL JOIN version of q1
SELECT DOCTOR.name, PATIENT.name FROM DOCTOR NATURAL LEFT JOIN APPOINTMENT NATURAL LEFT JOIN PATIENT;


-- to view tables
SELECT * FROM DOCTOR; 
SELECT * FROM PATIENT;
SELECT * FROM APPOINTMENT;
