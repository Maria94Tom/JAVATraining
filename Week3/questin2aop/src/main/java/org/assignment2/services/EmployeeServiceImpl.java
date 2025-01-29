package org.assignment2.services;

import org.assignment2.annotation.Loggable;
import org.assignment2.persistence.Employee;
import org.assignment2.persistence.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value="es")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
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

        return dao.addEmployee(employee);
    }

    @Loggable
    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public void updateEmployee(int id, Employee employee) {

    }

    @Override
    public Employee getEmployeeById(int id) {

        return dao.getEmployeeById(id);
    }
}
