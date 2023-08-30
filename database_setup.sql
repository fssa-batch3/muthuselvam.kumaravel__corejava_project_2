-- Create the 'inifiniti' database if it doesn't exist and switch to it
-- CREATE DATABASE IF NOT EXISTS inifiniti;
USE inifiniti;

-- Create the 'users' table to store user information
CREATE TABLE IF NOT EXISTS user (
username VARCHAR(50) ,
email VARCHAR(50),
password VARCHAR(20),
id int,
logged_in TINYINT (1)
);

-- Retrieve all records from 'users' table
SELECT * FROM user;

-- Insert a sample user record
INSERT INTO user (username , email , password) VALUES ("muthu","sriyaasha@gmail.com","Muthu@143");

-- Create the 'bookings' table to store booking information
CREATE TABLE IF NOT EXISTS bookings (
shuttle_id int ,
username VARCHAR(50),
destination VARCHAR(20),
seat_num int,
booking_id int,
email varchar(200)
);

-- Retrieve all records from 'bookings' table
SELECT * FROM bookings;

-- Insert a sample booking record
INSERT INTO bookings (shuttle_id , username , email, destination , seat_num ) VALUES (1,"muthu","sriyaasha@gmail.com","taramani",6);

-- Create the 'shuttle' table to store shuttle information
CREATE TABLE IF NOT EXISTS shuttle (
date VARCHAR(50),
time VARCHAR(20),
shuttle_id int,
company_name varchar(255)
);

-- Retrieve all records from 'shuttle' table
SELECT * FROM shuttle;

-- Insert a sample booking record
INSERT INTO shuttle (shuttle_id ,company_name ,  date , time ) VALUES (1,"FRESHWORKS","29/08/2023","09:00");

-- Create the 'company' table to store shuttle information
CREATE TABLE IF NOT EXISTS company (
company_id int,
company_name varchar(50),
image_url varchar(2047)
);

-- Retrieve all records from 'shuttle' table
SELECT * FROM company;

-- Insert a sample booking record
INSERT INTO company (company_name , image_url) VALUES ("FRESHWORKS","https://encrytped.io.qrscnnaer.4232")