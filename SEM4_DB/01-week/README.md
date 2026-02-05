## Connection Guide (University Only)
- Download and Open MySQL Workbench
- Create a new MySQL Connection
- Enter Parameters
- Connection Name: <your name>
- HostName: 172.16.100.8
- Port: 3306
- Username: <bitsid>
- Store in Keychain: enter default password "a"

## Installation and Setup for local DB
- Install from the official [site](https://www.mysql.com/downloads/)
- Product to be installed:
  - MySQL Server
  - MySQL Workbench
  - MySQL Shell
  - Connector Host language (python/java)
- Download and Setup with username and password
- Open MySQL Command Line Client and enter pass if its correctly entered, it will show MySQL (Terminal View)
- Code for Python Connection
```python
import mysql.connector

conn = mysql.connector.connect(
        host="localhost",
        user="root",
        password="password",
        database="mydb"
    )

if conn.is_connected():
        cursor = conn.cursor()
        cursor.execute("INSERT INTO students (id, name) VALUES (1, 'Alex')")
        conn.commit()
        print("Query executed and committed")

else:
    print("Not connected to MySQL")


```


## Create Database
- Use ';' at the end of line
- Use 'use' command to use/specify a table
- Use `CHAR`, `VARCHAR`, `INT`, `DATE`, `TIME`, `YEAR`, `FLOAT`, `TEXT`, `SET`
- If there is any mistake we can use `ALTER` command to edit the table
  - ALTER MODIFY (change the data type without changing the column name)
  - ALTER CHANGE (to rename a column name in the table) 
  - ALTER ADD (to add more column in the table)
  - ALTER INSERT (to add data in the table)
- SELECT * FROM <tablename> -- (this lets you see your table)


## Database Managment System
- Defination: Relational database is organized into tables with rows and columns where they are related to each other.
- MySQL is RDBMS (Relational Database Managment System)


#### Terms in Relation Model
- **Relation**: Table storing related data
- **Domain**: Pool of values from which actual values drawn
- **Tuple**: A row of relation/ basically row in table
- **Attribute**: A column of relation/ basically column in table
- **Degree**: Number of Columns in a table
- **Cardinality**: Number of rows in a table
- **Primary Key**: Set of one or more attributes that can uniquely identify tuples within the relation
- **Candidate Key**: All attribute combination inside relation that can serve as Primary Key
- **Alternate Key**: A candidate key that is not Primary Key
- **Foreign Key**: A non-key attribute whose value derived from primary key of some other table

#### Referential Integrity Constraint
It is a system of rules that DBMS uses to ensure Relation between records are valid, and user don't accidently delete or change related data.

###### SQL Statements 
- DDL: Data Defination Langauge (CREATE, ALTER, DROP)
  - ALTER has 4 combinations with (ADD, MODIFY, DROP, CHANGE)
- DML: Data Manipulation Language (SELECT, INSERT, UPDATE, DELETE)
  - SELECT has 4 aggregate functions (SUM(), MIN(), AVG(), MAX())
- DCL: Data Control Language
- TCL: Transaction Control Language
