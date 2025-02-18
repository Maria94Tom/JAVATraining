package bankingapp;

public class MainClass {
    public static void main(String[] args) throws NotSufficientFundException {
        Account account = new Account(2000);
        account.deposit(1000);
        account.deposit(10000);
        account.withdraw(500);
        account.withdraw(2000000);
    }
}
