DROP DATABASE IF EXISTS WEEK10;

CREATE DATABASE WEEK10;
USE WEEK10;

CREATE TABLE Employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(50),
    base_salary DECIMAL(10, 2)
);

CREATE TABLE Salary_History (
    emp_id INT,
    old_salary DECIMAL(10, 2),
    new_salary DECIMAL(10, 2),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Tax_Log (
    emp_id INT,
    tax_amount DECIMAL(10, 2)
);

#function to calculate tax
DELIMITER //
CREATE FUNCTION CalculateTax(salary DECIMAL(10, 2)) 
RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
    DECLARE tax DECIMAL(10, 2);
    IF salary < 50000 THEN
        SET tax = salary * 0.10; 
    ELSE
        SET tax = salary * 0.20; 
    END IF;
    RETURN tax;
END //
DELIMITER ;

#trigger for bonus logic (Must be BEFORE to modify NEW values)
DELIMITER //
CREATE TRIGGER Before_Salary_Update
BEFORE UPDATE ON Employees
FOR EACH ROW
BEGIN
    IF NEW.base_salary > 80000 THEN
        SET NEW.base_salary = NEW.base_salary + 5000; 
    END IF;
END //
DELIMITER ;

#trigger for salary history and tax logging
DELIMITER //
CREATE TRIGGER After_Salary_Update
AFTER UPDATE ON Employees
FOR EACH ROW
BEGIN
    INSERT INTO Salary_History(emp_id, old_salary, new_salary)
    VALUES (OLD.emp_id, OLD.base_salary, NEW.base_salary);

    # this is usinng function
    INSERT INTO Tax_Log(emp_id, tax_amount)
    VALUES (NEW.emp_id, CalculateTax(NEW.base_salary));
END //
DELIMITER ;

#procedure to update salary
DELIMITER //
CREATE PROCEDURE UpdateSalary(IN p_emp_id INT, IN p_increment DECIMAL(10, 2))
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK; #rollback on error, exception handling
        RESIGNAL; # <--- THIS MAKES THE ERROR RED IN WORKBENCH
    END;

    START TRANSACTION;

    #Validate input condition
    IF p_emp_id <= 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid Employee ID Format';
    END IF;
    
    IF p_increment < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid Increment';
    END IF;

    #updating salary
    UPDATE Employees 
    SET base_salary = base_salary + p_increment 
    WHERE emp_id = p_emp_id;

    IF ROW_COUNT() = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Employee ID not found in database';
    END IF;
    
    COMMIT;
END //
DELIMITER ;





INSERT INTO Employees VALUES (1, 'Pratham', 45000);
INSERT INTO Employees VALUES (2, 'Rahul', 55000);  
INSERT INTO Employees VALUES (3, 'Karan', 82000);  
INSERT INTO Employees VALUES (4, 'Krrish', 30000); 
INSERT INTO Employees VALUES (5, 'Aaron', 75000);





#checking if valid increment
#CALL UpdateSalary(1, 10000); # Should trigger 20% tax and history log

#checking if invalid increment this would show SIGNAL error
CALL UpdateSalary(1, -500); 

#for non existing id
CALL UpdateSalary(99, 5000);

#for invalid emp id format
CALL UpdateSalary(0, 5000);

SELECT * FROM Employees;
SELECT * FROM Salary_History;
SELECT * FROM Tax_Log;
