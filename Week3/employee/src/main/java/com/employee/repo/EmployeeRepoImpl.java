package com.employee.repo;
import com.employee.entities.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    @Repository(value ="dao")
    @Primary
    public class EmployeeRepoImpl implements EmployeeRepo {
        private static final Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();
        private static int counter = 0;
        static {
            empMap.put(++counter,
                    new Employee(counter, "Raj", "IT" ,600000));
            empMap.put(++counter, new Employee(counter, "Ekta", "IT" ,500000));
        }

        @Override
        public List<Employee> getAllEmployees() {
            return new ArrayList<Employee>(empMap.values());
        }

        @Override
        public Employee addEmployee(Employee employee) {
            empMap.put(counter, employee);
            return empMap.get(counter);
        }

        @Override
        public void deleteEmployee(int id) {
            empMap.remove(id);
        }

        @Override
        public void updateEmployee (int id, Employee employee) {
            empMap.put(id, employee);
        }

        @Override
        public Employee getEmployeeById(int id) {
            return empMap.get(id);
        }

    }




