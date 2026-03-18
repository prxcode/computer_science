
CREATE DATABASE FAQIRCHANDLIB;
USE FAQIRCHANDLIB;

CREATE TABLE BOOK (
    book_id INT PRIMARY KEY,
    title VARCHAR(255),
    Author VARCHAR(255),
    Price DECIMAL(10, 2)
);
INSERT INTO BOOK VALUES (101, 'Art of War', 'Sun Tzu', 50.00);
INSERT INTO BOOK VALUES (102, 'Wings of Fire', 'Dr. APJ Abdul Kalam', 120.00);
INSERT INTO BOOK VALUES (103, 'Harry Potter', 'J. K. Rowling', 80.00);

CREATE TABLE MEMBER (
    member_id INT PRIMARY KEY,
    name VARCHAR(255),
    city VARCHAR(255),
    Membership_date DATE
);
INSERT INTO MEMBER VALUES (1, 'Nikhil', 'Delhi', '2025-01-10');
INSERT INTO MEMBER VALUES (2, 'Suraj', 'Dubai', '2025-02-15');

CREATE TABLE BORROW (
    borrow_id INT PRIMARY KEY,
    borrow_date DATE,
    return_date DATE,
    book_id INT,
    member_id INT,
    FOREIGN KEY (book_id) REFERENCES BOOK(book_id),
    FOREIGN KEY (member_id) REFERENCES MEMBER(member_id)
);
INSERT INTO BORROW VALUES (501, '2026-03-01', '2026-03-10', 101, 1);
INSERT INTO BORROW VALUES (502, '2026-03-05', '2026-03-15', 102, 1);
INSERT INTO BORROW VALUES (503, '2026-03-18', NULL, 101, 1);


SELECT * FROM BOOK;
SELECT * FROM MEMBER;
SELECT * FROM BORROW;

#01. display member name, book title, and borrow date
SELECT M.name, B.title, BR.borrow_date FROM BORROW BR JOIN MEMBER M ON BR.member_id = M.member_id JOIN BOOK B ON BR.book_id = B.book_id;

#02. display members who have borrowed more than two books
SELECT M.name FROM MEMBER M JOIN BORROW BR ON M.member_id = BR.member_id GROUP BY M.member_id HAVING COUNT(BR.borrow_id) > 2;

#03. display books that have never been borrowed
SELECT title FROM BOOK WHERE book_id NOT IN (SELECT book_id FROM BORROW);

#04. display members who borrowed books costing more than the avg book price
SELECT DISTINCT M.name FROM MEMBER M JOIN BORROW BR ON M.member_id = BR.member_id JOIN BOOK B ON BR.book_id = B.book_id WHERE B.Price > (SELECT AVG(Price) FROM BOOK);

#05. create a view showing number of books borrowed by each member
CREATE VIEW MemberBorrowCount AS SELECT member_id, COUNT(borrow_id) AS total_borrowed FROM BORROW GROUP BY member_id;

#06. create a view showing the total number of books borrowed in each month
CREATE VIEW MonthlyBorrowStats AS SELECT MONTHNAME(borrow_date) AS borrow_month, COUNT(borrow_id) AS total_borrows FROM BORROW GROUP BY borrow_month;

#07. create an index on the borrow_date attribute
CREATE INDEX idx_borrow_date ON BORROW(borrow_date);

#08. add a CHECK constraint ensuring price > 0
ALTER TABLE BOOK ADD CONSTRAINT chk_book_price CHECK (Price > 0);

#09. grant SELECT privilege on BOOK table to user librarian
GRANT SELECT ON BOOK TO 'librarian'@'localhost';
FLUSH PRIVILEGES;

#10. revoke the privilege:
REVOKE SELECT ON BOOK FROM 'librarian'@'localhost';
