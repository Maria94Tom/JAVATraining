package org.assignment1.persistence;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAllEmployees();
    public Employee addEmployee ( Employee employee);
    public void deleteEmployee (int id);
    public void updateEmployee (int id, Employee employee);
    public Employee getEmployeeById(int id);

}
