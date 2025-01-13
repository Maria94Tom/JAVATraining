package AssignmentQ3;

class CurrentAccount extends Account {
    private boolean hasTradingLicense;
    private final double overdraftLimit = 10000.0; // overdraft limit

    // Constructor to initialize current account
    public CurrentAccount(String accountHolder, boolean hasTradingLicense) {
        super(accountHolder);
        this.accountType = "Current Account";
        this.hasTradingLicense = hasTradingLicense;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (hasTradingLicense) {
            if (balance - amount >= -overdraftLimit) {
                balance -= amount;
                System.out.println("Withdrew: " + amount);
            } else {
                System.out.println("Withdrawal exceeds overdraft limit.");
            }
        } else {
            System.out.println("Current account requires a valid trading license.");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Method to check overdraft limit
    public void checkOverdraftLimit() {
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

