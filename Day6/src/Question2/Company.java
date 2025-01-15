package Question2;

public class Company extends Thread {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000); // Try to deposit 1000 for 100 times
        }
    }
}