package org.assignment2.persistence;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployees();
    public Employee addEmployee ( Employee employee);
    public int deleteEmployee (int id);
    public void updateEmployee (int id, Employee employee);
    public Employee getEmployeeById(int id);

}
