package com.employee.controller;


import com.employee.entities.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {
private EmployeeService employeeService;

@Autowired
public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
}

@GetMapping("/employees")
public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
}

@GetMapping(path="employees/{id}")
public Employee getEmployeeById(int id) {
    return employeeService.getEmployeeById(id);

}

@PostMapping(path="employees")
public void addEmployee(Employee employee) {
    employeeService.addEmployee(employee);
}

@PutMapping(path="employees/{id}")
public void updateEmployee(int id, Employee employee) {
    employeeService.updateEmployee(id, employee);
}

@DeleteMapping(path="employees/{id}")
public void deleteEmployee(int id) {
    employeeService.deleteEmployee(id);
}

}
