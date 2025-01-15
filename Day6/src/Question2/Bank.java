package Question2;

public class Bank extends Thread {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000); // Try to withdraw 1000 for 100 times
        }
    }
}