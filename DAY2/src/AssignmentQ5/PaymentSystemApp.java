package AssignmentQ5;
interface Payable {
    void getPayment();  // Method to display information and calculate payment
}
public class PaymentSystemApp {
    public static void main(String[] args) {
        // Creating objects for each type of Employee
        Employee salariedEmployee = new SalariedEmployee("John Doe", "E001", 1000);
        Employee hourlyEmployee = new HourlyEmployee("Jane Smith", "E002", 25, 40);
        Employee commissionEmployee = new CommissionEmployee("Alice Brown", "E003", 5000, 10);

        // Creating Invoice objects
        Invoice invoice1 = new Invoice("INV001", "Company A", 1500.50);
        Invoice invoice2 = new Invoice("INV002", "Company B", 2500.75);

        // Displaying the payment information
        System.out.println("----- Employee Payments -----");
        salariedEmployee.getPayment();
        hourlyEmployee.getPayment();
        commissionEmployee.getPayment();

        System.out.println("----- Invoice Payments -----");
        invoice1.getPayment();
        invoice2.getPayment();

        // Testing salary increase
        System.out.println("\nApplying salary increase to Hourly Employee (10%)");
        hourlyEmployee.increaseSalary(10);
        hourlyEmployee.getPayment();
    }
}
