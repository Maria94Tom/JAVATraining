package AssignmentQ5;

abstract class Employee implements Payable {
    protected String name;
    protected String employeeId;

    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // Abstract method to calculate weekly salary
    public abstract double calculateWeeklySalary();

    public abstract void increaseSalary(double percentage);

    // Implementing getPayment() for Employee
    @Override
    public void getPayment() {
        System.out.println("\nEmployee Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
    }
}