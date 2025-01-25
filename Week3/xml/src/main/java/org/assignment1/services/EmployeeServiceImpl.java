package org.assignment1.services;

import org.assignment1.persistence.Employee;
import org.assignment1.persistence.EmployeeDao;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao dao;

    public void setDao(EmployeeDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public void updateEmployee(int id, Employee employee) {

    }

    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }
}
