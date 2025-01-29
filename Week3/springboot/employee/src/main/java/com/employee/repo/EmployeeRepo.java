package com.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
//    public List<Employee> getAllEmployees();
//    public Employee addEmployee ( Employee employee);
//    public void deleteEmployee (int id);
//    public void updateEmployee (int id, Employee employee);
//    public Employee getEmployeeById(int id);
}
