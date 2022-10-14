package com.fofe.employeemanager.services;

import com.fofe.employeemanager.exeption.EmployeeNotFoundExeption;
import com.fofe.employeemanager.model.Employee;
import com.fofe.employeemanager.repository.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new EmployeeNotFoundExeption("user" +id+ "was not found"));
    }

    public void deleteEmployee(Long id){
         employeeRepo.deleteById(id);
    }
}
