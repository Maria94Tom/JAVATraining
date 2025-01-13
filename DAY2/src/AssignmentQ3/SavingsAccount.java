package AssignmentQ3;

class SavingAccount extends Account {
    private final double interestRate = 0.05; // 5% interest rate
    private final double minimumBalance = 5000.0;

    // Constructor to initialize saving account
    public SavingAccount(String accountHolder) {
        super(accountHolder);
        this.accountType = "Saving Account";
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= minimumBalance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance. Minimum balance of " + minimumBalance + " is required.");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Method to calculate interest
    public void calculateInterest(int months) {
        double interest = balance * Math.pow((1 + interestRate), months) - balance;
        System.out.println("Interest for " + months + " months: " + interest);
    }
}
