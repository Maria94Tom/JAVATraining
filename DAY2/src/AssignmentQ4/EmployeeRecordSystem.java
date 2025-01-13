package AssignmentQ4;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected String employeeId;

    // Constructor to initialize employee name and ID
    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // Abstract method to calculate weekly salary
    public abstract double calculateWeeklySalary();

    // Method to increase salary by a percentage
    public abstract void increaseSalary(double percentage);

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}

// SalariedEmployee class
class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String name, String employeeId, double weeklySalary) {
        super(name, employeeId);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculateWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public void increaseSalary(double percentage) {
        weeklySalary += weeklySalary * (percentage / 100);
        System.out.println(name + "'s new weekly salary: " + weeklySalary);
    }
}

public class EmployeeRecordSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        // Adding some employees to the system
        employees.add(new SalariedEmployee("John Doe", "E001", 1000));
        employees.add(new HourlyEmployee("Jane Smith", "E002", 20, 40));
        employees.add(new CommissionEmployee("Alice Brown", "E003", 5000, 10));

        while (!exit) {
            System.out.println("\nEmployee Record System:");
            System.out.println("1. Display All Employees' Weekly Salary");
            System.out.println("2. Increase Salary of Specific Employee Type");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    displayWeeklySalaries();
                    break;
                case 2:
                    increaseSalaryOfEmployeeType(scanner);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the Employee Record System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    // Display weekly salary of all employees
    private static void displayWeeklySalaries() {
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " (" + employee.getEmployeeId() + ") - Weekly Salary: " + employee.calculateWeeklySalary());
        }
    }

    // Increase salary of a specific employee type
    private static void increaseSalaryOfEmployeeType(Scanner scanner) {
        System.out.println("Select Employee Type to Increase Salary:");
        System.out.println("1. Salaried Employee");
        System.out.println("2. Hourly Employee");
        System.out.println("3. Commission Employee");
        System.out.print("Enter your choice: ");
        int employeeType = scanner.nextInt();
        System.out.print("Enter the percentage increase: ");
        double percentage = scanner.nextDouble();

        for (Employee employee : employees) {
            if ((employeeType == 1 && employee instanceof SalariedEmployee) ||
                    (employeeType == 2 && employee instanceof HourlyEmployee) ||
                    (employeeType == 3 && employee instanceof CommissionEmployee)) {
                employee.increaseSalary(percentage);
            }
        }
    }
}