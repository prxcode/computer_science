USE 2024A7PS0081Udb;
CREATE TABLE Salesman(
	id INT PRIMARY KEY,
    name VARCHAR(30),
    city VARCHAR(20),
	commission float);
    
    INSERT INTO Salesman VALUES 
    (123, 'Pankaj', 'Delhi', 0.10),
    (456, 'Rahul', 'Mumbai', 0.33),
    (789, 'Sanjay', 'Banglore', 0.14);
    
 
CREATE TABLE Customer(
	id INT PRIMARY KEY,
    name VARCHAR(20),
    city VARCHAR(20),
    grade CHAR(1),
    salesman_id INT);
    
	INSERT INTO Customer VALUES 
    (122, 'Ajay', 'Kolkata', 'A', 123),
    (455, 'Aman', 'Mumbai', 'B', 123),
    (788, 'Pratham', 'Banglore', 'A', 456);
    
   
    CREATE TABLE Orders(
	id INT PRIMARY KEY,
    purchase_amount INT,
    order_date DATE,
    customer_id INT,
    salesman_id INT);
    
	INSERT INTO Orders VALUES 
    (1, 599, '2002-05-01', 122, 123),
    (2, 1499, '1998-07-14', 788, 456),
    (3, 667, '2006-02-14', 455, 456);
    
    -- List salesmen who have not recieved any orders
    SELECT name FROM Salesman s WHERE s.id NOT IN (SELECT Salesman_id FROM Orders);
    
    -- Display order where customer and salesman are from the same city
    SELECT o.* FROM Salesman s, Customer c, Orders o WHERE o.customer_id = c.id AND o.salesman_id = s.id AND c.city = s.city;
    
    -- Find cutomer who are assigned to a salesman form a different city
    SELECT c.name FROM Customer c, Salesman s WHERE c.salesman_id = s.id AND NOT c.city = s.city;
    
    -- Display orders palced through salesman with commission above 0.12
	SELECT o.* FROM Salesman s, Orders o WHERE o.salesman_id = s.id AND s.commission > 0.12; 
    
