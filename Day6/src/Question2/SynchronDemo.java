package Question2;

public class SynchronDemo {
    public static void main(String[] args) {
        // Create an Account object
        Account account = new Account();

        // Create Bank and Company objects (threads)
        Bank bank = new Bank(account);
        Company company = new Company(account);

        // Start the threads
        bank.start();
        company.start();

        // Wait for both threads to finish
        try {
            bank.join();
            company.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final account balance
        System.out.println("Final Account Balance: " + account.getBalance());
    }
}
