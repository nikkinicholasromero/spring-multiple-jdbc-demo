package com.demo.controller;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/employees", "/employees/"})
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
