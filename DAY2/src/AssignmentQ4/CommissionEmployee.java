package AssignmentQ4;

class CommissionEmployee extends Employee {
    private double salesAmount;
    private double commissionPercentage;

    public CommissionEmployee(String name, String employeeId, double salesAmount, double commissionPercentage) {
        super(name, employeeId);
        this.salesAmount = salesAmount;
        this.commissionPercentage = commissionPercentage;
    }

    @Override
    public double calculateWeeklySalary() {
        return (commissionPercentage * salesAmount) / 100;
    }

    @Override
    public void increaseSalary(double percentage) {
        commissionPercentage += commissionPercentage * (percentage / 100);
        System.out.println(name + "'s new commission percentage: " + commissionPercentage);
    }
}
