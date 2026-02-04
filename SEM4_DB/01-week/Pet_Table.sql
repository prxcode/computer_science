USE 2024A7PS0081Udb;
CREATE TABLE pet(
    Name VARCHAR(30),
    Owner VARCHAR(30),
    Species VARCHAR(20),
    Sex CHAR(1),
	Birth DATE);
    
    
    INSERT INTO pet VALUES 
    ('Fluffy', 'Harold', 'cat', 'f', '1993-02-04'),
    ('Claws', 'Gwen', 'cat', 'm', '1994-03-17'),
    ('Buffy', 'Harold', 'dog', 'f', '1989-05-13'),
    ('Fang', 'Benny', 'dog', 'm', '1990-08-27');
    SELECT * FROM pet; -- TO view the result run this cmd, use cmd + shift + enter to run this line only
	ALTER TABLE pet Add Death VARCHAR(30);
    
    
    -- Q1. Display all details of pet Fang.
    SELECT * FROM pet WHERE Name = 'Fang';
    
    -- Q2. Display all details of pets of Gwen.
    SELECT * FROM pet WHERE Owner = 'Gwen';
    
	-- Q3. Display the owner names of all dogs.
    SELECT Owner FROM pet WHERE Species = 'dog';
    
    -- Q4. Display details of all female pets.
    SELECT * FROM pet where Sex = 'f';
    
    -- Q5. Display the DOB of hamster.
    SELECT Birth FROM pet where Species = 'hamster';
