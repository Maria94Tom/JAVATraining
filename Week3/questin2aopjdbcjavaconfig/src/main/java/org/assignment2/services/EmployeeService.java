package org.assignment2.services;

import org.assignment2.persistence.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public Employee addEmployee (Employee employee);
    public boolean deleteEmployee (int id);
    public void updateEmployee (int id, Employee employee);
    public Employee getEmployeeById(int id);

}
