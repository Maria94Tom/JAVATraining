package Question2;

    public class Account {
        private double balance;

        // Getter and Setter for balance
        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        // Synchronized method to add an amount to balance
        public synchronized void addAmount(double amount) {
            double newBalance = balance + amount;
            // Simulate some processing delay
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = newBalance;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        }

        // Synchronized method to subtract an amount from balance
        public synchronized void subtractAmount(double amount) {
            if (balance >= amount) {
                double newBalance = balance - amount;
                // Simulate some processing delay
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance = newBalance;
                System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
            } else {
                System.out.println("Insufficient funds to withdraw: " + amount);
            }
        }
    }
