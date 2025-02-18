package bankingapp;

public class Account {
    private double balance;
    public static final double MIN_BALANCE = 1000.0;
    public static final double MAX_BALANCE = 1500000.0;

    public Account(double balance) throws NotSufficientFundException {
        if (balance < MIN_BALANCE) {
            throw new NotSufficientFundException("Balance must be between " + MIN_BALANCE + " and " + MAX_BALANCE);
        }
        if(balance > MAX_BALANCE) {
            throw new FundOverflowException("Balance must be between " + MIN_BALANCE + " and " + MAX_BALANCE);
        }


    }
    public void withdraw(double amount) throws NotSufficientFundException {
        if (amount > balance) {
            throw new NotSufficientFundException("Amount must be greater than 0");
        }
        else {
            balance -= amount;
        }
        System.out.println(balance);
    }
    public void deposit(double amount) {
       double temp = balance +amount;
        if (temp > MAX_BALANCE) {
            throw new FundOverflowException("Amount must be greater than 0");
        }
        else {
            balance += amount;
        }
        System.out.println(balance);
    }
}
