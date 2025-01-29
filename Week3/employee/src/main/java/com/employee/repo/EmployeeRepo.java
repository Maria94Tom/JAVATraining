package com.employee.repo;

import com.employee.entities.Employee;

import java.util.List;

public interface EmployeeRepo {
    public List<Employee> getAllEmployees();
    public Employee addEmployee ( Employee employee);
    public void deleteEmployee (int id);
    public void updateEmployee (int id, Employee employee);
    public Employee getEmployeeById(int id);

}
