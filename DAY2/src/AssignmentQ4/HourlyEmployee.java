package AssignmentQ4;

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(String name, String employeeId, double hourlyRate, double hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void increaseSalary(double percentage) {
        hourlyRate += hourlyRate * (percentage / 100);
        System.out.println(name + "'s new hourly rate: " + hourlyRate);
    }
}
