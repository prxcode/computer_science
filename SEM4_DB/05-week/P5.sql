CREATE DATABASE IF NOT EXISTS hospital_db;
USE hospital_db;


CREATE TABLE DOCTOR (
    doctor_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    specialization VARCHAR(100),
    license_number VARCHAR(50) UNIQUE
);

INSERT INTO DOCTOR VALUES 
(1, 'Dr. Sarah', 'Cardiology', 'LIC1001'),
(2, 'Dr. James', 'Neurology', 'LIC1002'),
(3, 'Dr. Neel', 'Pediatrics', 'LIC1003'),
(4, 'Dr. Robert', 'Dermatology', 'LIC1004'),
(5, 'Dr. Linda', 'Dentist', 'LIC1005'),
(6, 'Dr. Michael', 'General Practice', 'LIC1006');

CREATE TABLE PATIENT (
    patient_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100),
    age INT,
    CONSTRAINT chk_age CHECK (age > 0 AND age < 120)
);
INSERT INTO PATIENT VALUES 
(101, 'Suraj', 'New York', 30),
(102, 'Samwin', 'Chicago', 45),
(103, 'Pratham', 'Boston', 12),
(104, 'Peter', 'Seattle', 28),
(105, 'Suryansh', 'Austin', 50),
(106, 'Fiona', 'Miami', 35),
(107, 'John', 'Denver', 62),
(108, 'Hannah', 'Phoenix', 22);

CREATE TABLE APPOINTMENT (
    appointment_id INT PRIMARY KEY,
    doctor_id INT,
    patient_id INT,
    visit_date DATE,
    status VARCHAR(20),
    FOREIGN KEY (doctor_id) REFERENCES DOCTOR(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES PATIENT(patient_id),
    CONSTRAINT chk_status CHECK (status IN ('Scheduled', 'Completed', 'Cancelled')));

INSERT INTO APPOINTMENT VALUES 
(1, 1, 101, '2024-01-10', 'Completed'),
(2, 2, 102, '2024-01-12', 'Completed'),
(3, 3, 103, '2024-01-15', 'Completed'),
(4, 4, 104, '2024-01-20', 'Scheduled'),
(5, 5, 105, '2024-02-01', 'Completed'),
(6, 6, 106, '2024-02-05', 'Cancelled'),
(7, 1, 107, '2024-02-10', 'Completed'),
(8, 2, 108, '2024-02-15', 'Scheduled'),
(9, 3, 101, '2024-02-20', 'Completed'),
(10, 4, 102, '2024-02-25', 'Completed');


CREATE VIEW doctor_patient_view AS SELECT d.name AS doctor_name, p.name AS patient_name, a.visit_date FROM DOCTOR d JOIN APPOINTMENT a ON d.doctor_id = a.doctor_id JOIN PATIENT p ON a.patient_id = p.patient_id;
SELECT * FROM doctor_patient_view;

-- creating indexes 
CREATE INDEX idx_doctor_appt ON APPOINTMENT(doctor_id);
CREATE INDEX idx_patient_appt ON APPOINTMENT(patient_id);
SHOW INDEX FROM APPOINTMENT;

-- creating role 
CREATE ROLE 'doctor_role';

-- grant intial privileges
GRANT SELECT ON hospital_db.DOCTOR TO 'doctor_role';
GRANT SELECT ON hospital_db.APPOINTMENT TO 'doctor_role';

-- create user and assign role
CREATE USER 'doctor_user'@'localhost' IDENTIFIED BY 'JOKER';
GRANT 'doctor_role' TO 'doctor_user'@'localhost';
SET DEFAULT ROLE 'doctor_role' TO 'doctor_user'@'localhost';

-- grant view access adn revoke direct table 
GRANT SELECT ON hospital_db.doctor_patient_view TO 'doctor_role';
REVOKE SELECT ON hospital_db.APPOINTMENT FROM 'doctor_role';

SHOW GRANTS FOR 'doctor_role';
SHOW GRANTS FOR 'doctor_user'@'localhost' USING 'doctor_role';
