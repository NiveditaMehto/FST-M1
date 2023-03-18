REM   Script: Activity1_SQL
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


