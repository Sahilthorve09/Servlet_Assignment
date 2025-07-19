CREATE DATABASE IF NOT EXISTS employee_management;
USE employee_management;
CREATE TABLE employees (
    emp_id VARCHAR(20) PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone BIGINT,
    gender VARCHAR(10),
    address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code INT,
    department VARCHAR(50),
    designation VARCHAR(50),
    qualification VARCHAR(100),
    experience_years INT,
    password VARCHAR(100)
);

select * from employees;


