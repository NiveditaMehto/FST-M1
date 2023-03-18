REM   Script: Activity5
REM   SQLActivity

SELECT column1, column2, ... 
FROM table_name;

CREATE TABLE tableName;

CREATE TABLE Customers ( 
    CustomerID int, 
    CustomerName varchar(52), 
    ContactName varchar(32), 
    Address varchar(255), 
    City varchar(50), 
    PostalCode varchar(20), 
    Country varchar(20) 
);

CREATE TABLE Customers ( 
    CustomerID int, 
    CustomerName varchar(52), 
    ContactName varchar(32), 
    Address varchar(255), 
    City varchar(50), 
    PostalCode varchar(20), 
    Country varchar(20) 
);

DESCRIBE Customers 


CREATE TABLE Customers ( 
    CustomerID int PRIMARY KEY, 
    CustomerName varchar(52), 
    ContactName varchar(32), 
    Address varchar(255), 
    City varchar(50), 
    PostalCode varchar(20), 
    Country varchar(20) 
);

DESCRIBE Customers 


CREATE TABLE Customers ( 
    CustomerID int PRIMARY KEY, 
    CustomerName varchar(52) NOT NULL, 
    ContactName varchar(32), 
    Address varchar(255), 
    City varchar(50), 
    PostalCode varchar(20), 
    Country varchar(20) 
);

DESCRIBE Customers 


CREATE TABLE tableName ( 
    salesman_id int PRIMARY KEY, 
    salesman_name varchar2(20) NOT NULL, 
    salesman_city varchar2(20), 
    commission int 
    
);

DESCRIBE tableName 


CREATE TABLE tableName ( 
    salesman_id int PRIMARY KEY, 
    salesman_name varchar2(20) , 
    salesman_city varchar2(20), 
    commission int 
    
);

DESCRIBE tableName 


CREATE TABLE salesman ( 
    salesman_id int PRIMARY KEY, 
    salesman_name varchar2(20) , 
    salesman_city varchar2(20), 
    commission int 
    
);

DESCRIBE salesman 


INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

SELECT salesman_id, salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

SELECT * FROM salesman;

UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

SELECT * FROM salesman;

