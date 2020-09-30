package com.example.demo.services;

import com.example.demo.models.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee getEmployeeByName(String name);
    public List<Employee> getAllEmployees();

}
