
DROP DATABASE IF EXISTS WEEK9;
CREATE DATABASE WEEK9;
USE WEEK9;


CREATE TABLE Employees (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(100),
    salary DECIMAL(10, 2)
);

# to increase salary 
DELIMITER //
CREATE PROCEDURE IncreaseSalary(
    IN p_emp_id INT, 
    IN p_increment DECIMAL(10, 2)
)
BEGIN
    UPDATE Employees 
    SET salary = salary + p_increment 
    WHERE emp_id = p_emp_id;
END //
DELIMITER ;

#calculate 10% Tax
DELIMITER //
CREATE FUNCTION CalculateTax(p_salary DECIMAL(10, 2)) 
RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
    RETURN p_salary * 0.10;
END //
DELIMITER ;

#adding 500 bonus
DROP TRIGGER IF EXISTS bonus_trigger;

DELIMITER //
CREATE TRIGGER bonus_trigger
BEFORE UPDATE ON Employees
FOR EACH ROW
BEGIN
    IF NEW.salary > 70000 THEN
        SET NEW.salary = NEW.salary + 500;
    END IF;
END //
DELIMITER ;

INSERT INTO Employees (emp_name, salary) VALUES 
('Rahul', 45000),
('Sam', 68000),
('John', 58000),
('Nikhil', 55000),
('Pratham', 67000);

#initial check
SELECT emp_id, emp_name, salary, CalculateTax(salary) AS tax_amount 
FROM Employees;


CALL IncreaseSalary(2, 3000);

SELECT emp_id, emp_name, salary, CalculateTax(salary) AS tax_amount 
FROM Employees;
