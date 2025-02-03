package com.employee.service;


import com.employee.entities.Employee;
import com.employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="es")
    public class EmployeeServiceImpl implements EmployeeService {

        @Autowired
        private EmployeeRepo dao;


        public void setDao(EmployeeRepo dao) {
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


        @Override
        public void deleteEmployee(int id) {
            dao.deleteEmployee(id);

        }

        @Override
        public void updateEmployee(int id, Employee employee) {

            dao.updateEmployee(id, employee);
            

        }

        @Override
        public Employee getEmployeeById(int id) {

            return dao.getEmployeeById(id);
        }
    }


