package org.assignment1;
/*
Improve application design by dependency injection

1. Apply DI using xml
2. Apply DI using annotation
3. Apply DI using java configuraiton
4. we have used hard coded collection in dao layer, and initilized it

	private static Map<Integer, Employee> empsMap = new HashMap<Integer, Employee>();
	private static int counter = 0;
	static {
		empsMap.put(++counter, new Employee(counter, "Raj", "IT" , 60000000));
		empsMap.put(++counter, new Employee(counter, "Ekta", "Fin" , 70000000));
	}

Now replace this configuration with bean wiring in xml.


 */


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.assignment1.persistence.Employee;
import org.assignment1.services.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
    public static void main(String[] args) {
        // Load the Spring context from the XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");

        // Get the EmployeeService bean from the context
        EmployeeService employeeService = (EmployeeService) context.getBean("es");

        // Use the service to fetch and display employees
        System.out.println("All Employees:");
        for (Employee emp : employeeService.getAllEmployees()) {
            System.out.println(emp.getName());
        }

       //  Add a new employee
       employeeService.addEmployee(new Employee(3, "John Doe", "IT", 50000.0));
        System.out.println("Added Employee:" + employeeService.getEmployeeById(3).getName());
        System.out.println("Updated Employee list:");
        for (Employee emp : employeeService.getAllEmployees()) {
            System.out.println(emp.getName());

        }
        // Delete an employee
        employeeService.deleteEmployee(3);
        System.out.println("Updated Employee list:");
        for (Employee emp : employeeService.getAllEmployees()) {
            System.out.println(emp.getName());
        }

    }
}