USE 2024A7PS0081Udb;
CREATE TABLE Admission(
	No INT,
    Name VARCHAR(30),
    Age INT,
    Department VARCHAR(20),
    DateofAdm DATE,
    Fee INT,
    Sex CHAR(1));
    SET SQL_SAFE_UPDATES = 0;

	-- "--" use this to comment in SQL
    
    INSERT INTO Admission VALUES 
    (1, 'Pankaj', 24, 'Computer', '2002-10-12', 120, 'M'),
    (2, 'Shalini', 21, 'History', '2012-02-25', 120, 'M'),
    (3, 'Sanjay', 22, 'Hindi', '2010-10-10', 120, 'M'),
    (4, 'Sudha', 25, 'History', '2015-05-30', 120, 'M'),
    (5, 'Rakesh', 22, 'Hindi', '2012-12-12', 250, 'M'),
    (6, 'Shakeel', 30, 'History', '2016-01-03', 300, 'M'),
    (7, 'Surya', 34, 'Computer', '2002-10-12', 210, 'M');
    SELECT * FROM Admission; -- TO view the result run this cmd, use cmd + shift + enter to run this line only
    UPDATE Admission SET age = 27 WHERE NAME = 'Pankaj'; -- Updating table, use cmd + enter to run full code
    ALTER TABLE Admission Add City VARCHAR(30);
