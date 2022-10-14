package com.fofe.employeemanager.exeption;

public class EmployeeNotFoundExeption extends RuntimeException{
    public EmployeeNotFoundExeption(String message) {
        super(message);
    }
}
