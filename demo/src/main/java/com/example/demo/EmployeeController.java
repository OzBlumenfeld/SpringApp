package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return repository.findAll();
    }
    // Other CRUD endpoints handlers
}
