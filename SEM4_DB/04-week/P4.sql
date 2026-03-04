-- TASK I: Table Creation
CREATE TABLE DOCTOR (
    doctor_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    specialization VARCHAR(100)
);

CREATE TABLE PATIENT (
    patient_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100)
);

CREATE TABLE APPOINTMENT (
    appointment_id INT PRIMARY KEY,
    doctor_id INT,
    patient_id INT,
    visit_date DATE CHECK (visit_date <= CURRENT_DATE),
    FOREIGN KEY (doctor_id) REFERENCES DOCTOR(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES PATIENT(patient_id)
);

-- TASK II: Personalized Data Insertion
-- Inserting 6 Doctors (Doc 5 and 6 will have no appointments)
INSERT INTO DOCTOR VALUES (1, 'Dr. Smith', 'Cardiology');
INSERT INTO DOCTOR VALUES (2, 'Dr. Adams', 'Neurology');
INSERT INTO DOCTOR VALUES (3, 'Dr. Taylor', 'Pediatrics');
INSERT INTO DOCTOR VALUES (4, 'Dr. Brown', 'Dermatology');
INSERT INTO DOCTOR VALUES (5, 'Dr. Wilson', 'Oncology'); -- No appointments
INSERT INTO DOCTOR VALUES (6, 'Dr. Miller', 'General Practice'); -- No appointments

-- Inserting 8 Patients (Patient 7 and 8 will have no appointments)
INSERT INTO PATIENT VALUES (101, 'Alice Green', 'New York');
INSERT INTO PATIENT VALUES (102, 'Bob White', 'Chicago');
INSERT INTO PATIENT VALUES (103, 'Charlie Black', 'Boston');
INSERT INTO PATIENT VALUES (104, 'Diana Prince', 'Seattle');
INSERT INTO PATIENT VALUES (105, 'Edward Norton', 'Austin');
INSERT INTO PATIENT VALUES (106, 'Fiona Glen', 'Miami');
INSERT INTO PATIENT VALUES (107, 'George King', 'Denver'); -- No appointments
INSERT INTO PATIENT VALUES (108, 'Hannah Scott', 'Phoenix'); -- No appointments

-- Inserting Appointments (Linking some doctors and patients)
INSERT INTO APPOINTMENT VALUES (1, 1, 101, '2024-01-10');
INSERT INTO APPOINTMENT VALUES (2, 2, 102, '2024-01-12');
INSERT INTO APPOINTMENT VALUES (3, 3, 103, '2024-01-15');
INSERT INTO APPOINTMENT VALUES (4, 4, 104, '2024-01-20');
INSERT INTO APPOINTMENT VALUES (5, 1, 105, '2024-02-01');
INSERT INTO APPOINTMENT VALUES (6, 2, 106, '2024-02-05');


-- 1. List all doctors and their patients (include doctors without appointments)
SELECT D.name AS Doctor_Name, P.name AS Patient_Name
FROM DOCTOR D
LEFT JOIN APPOINTMENT A ON D.doctor_id = A.doctor_id
LEFT JOIN PATIENT P ON A.patient_id = P.patient_id;

-- 2. List all patients and their doctors (include patients without appointments)
SELECT P.name AS Patient_Name, D.name AS Doctor_Name
FROM APPOINTMENT A
JOIN DOCTOR D ON A.doctor_id = D.doctor_id
RIGHT JOIN PATIENT P ON A.patient_id = P.patient_id;

-- 3. Show doctors who never treated any patient
SELECT D.name
FROM DOCTOR D
LEFT JOIN APPOINTMENT A ON D.doctor_id = A.doctor_id
WHERE A.appointment_id IS NULL;

-- 4. Show patients who never had an appointment
SELECT P.name
FROM PATIENT P
LEFT JOIN APPOINTMENT A ON P.patient_id = A.patient_id
WHERE A.appointment_id IS NULL;

-- 5. Write a NATURAL JOIN version of Q1 (if possible)
SELECT name, specialization -- Columns from DOCTOR and PATIENT
FROM DOCTOR
NATURAL LEFT JOIN APPOINTMENT
NATURAL LEFT JOIN PATIENT;
