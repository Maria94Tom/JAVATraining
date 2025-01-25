package org.assignment1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.assignment1.config.AppConfig;
import org.assignment1.persistence.Employee;
import org.assignment1.services.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        // Load the Spring context from the XML configuration file
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the EmployeeService bean from the context
        EmployeeService employeeService = (EmployeeService) context.getBean("es");

        // Use the service to fetch and display employees
        System.out.println("All Employees:");
        for (Employee emp : employeeService.getAllEmployees()) {
            System.out.println(emp.getName());
        }

        // Add a new employee
//        Employee newEmployee = new Employee(3, "John", "HR", 8000000);
//        employeeService.addEmployee(newEmployee);
//        System.out.println("Added Employee: " + newEmployee.getName());
//
//        // Fetch all employees again to verify the addition
//        System.out.println("Updated Employee List:");
//        for (Employee emp : employeeService.getAllEmployees()) {
//            System.out.println(emp.getName());
//        }


    }
}