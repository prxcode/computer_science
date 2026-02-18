USE 2024A7PS0081Udb;
CREATE TABLE Salesman(
	id INT PRIMARY KEY,
    name VARCHAR(30),
    city VARCHAR(20),
	commission INT);
    
    INSERT INTO Admission VALUES 
    (123, 'Pankaj', 'Delhi', 100),
    (456, 'Rahul', 'Mumbai', 250),
    (789, 'Sanjay', 'Banglore', 500);
    
    
CREATE TABLE Customer(
	id INT PRIMARY KEY,
    name VARCHAR(20),
    city VARCHAR(20),
    grade CHAR(1),
    salesman_id INT);
    
	INSERT INTO Customer VALUES 
    (122, 'Ajay', 'Kolkata', 'A', 123),
    (455, 'Aman', 'Mumabi', 'B', 123),
    (788, 'Pratham', 'Banglore', 'A', 456);
    
    CREATE TABLE Orders(
	id INT PRIMARY KEY,
    purchase_amount INT,
    order_date DATE,
    customer_id INT,
    salesman_id INT);
    
	INSERT INTO Orders VALUES 
    (1, 599, 01-05-2002, 122, 123),
    (2, 1499, 14-07-1998, 788, 456),
    (3, 667, 14-02-2026, 455, 456);
    
    -- List salesmen who have not recieved any orders
    SELECT salesman.name
    
    -- Display order where customer and salesman are from the same city
    
    -- Find cutomer who are assigned to a salesman form a different city
    
