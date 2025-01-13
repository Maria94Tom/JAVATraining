package AssignmentQ3;

import java.util.Scanner;

/*
Q3. Assignment on Inheritance, Method overriding, Method overloading
A Banking System
Create a Banking System, where a user can create new account, deposit money, withdraw money
and check the balance.
For Simplicity, we will create the system for one customer. First the application will require the user
to create an account. After creating the account, he should have options to deposit, withdraw money,
and check balance as many times as he wants (until he exits the system).
When a user opens/creates an account, he has the option to open a “Saving Account” or a “Current
Account”.
See below for the requirements of Current and Savings account.
4) Saving account: A saving account allows user to accumulate interest on funds he has saved for
future needs. Interest rates can be compounded on a daily, weekly, monthly, or annual basis. Saving
account required a minimum balance. For our purpose let’s assume the minimum balance is 5000
and interest rate is 5% (From savings account, user is only allowed to withdraw a maximum amount
of money that available to his account)
5) Current account: Current account offers easy access to your money for your daily transactional
needs and helps keep your cash secure. You need a trading license to open a Current account.The
have overdraft option with current account
 */
abstract class Account {
    protected String accountHolder;
    protected double balance;
    protected String accountType;

    // Constructor to initialize account holder's name
    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void checkBalance();

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }
}

public class Customer {
    private static Account account;
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                boolean exit = false;

                System.out.println("Welcome to the Banking System!");

                // Account creation
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                // Choose account type
                System.out.println("Select Account Type:");
                System.out.println("1. Saving Account");
                System.out.println("2. Current Account");
                int accountTypeChoice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                if (accountTypeChoice == 1) {
                    account = new SavingAccount(name);
                } else if (accountTypeChoice == 2) {
                    System.out.print("Do you have a trading license? (yes/no): ");
                    String license = scanner.nextLine();
                    boolean hasLicense = license.equalsIgnoreCase("yes");
                    account = new CurrentAccount(name, hasLicense);
                } else {
                    System.out.println("Invalid choice. Exiting...");
                    return;
                }

                // User interaction for account operations
                while (!exit) {
                    System.out.println("\nMenu:");
                    System.out.println("1. Deposit Money");
                    System.out.println("2. Withdraw Money");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Exit");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            account.withdraw(withdrawAmount);
                            break;
                        case 3:
                            account.checkBalance();
                            if (account instanceof SavingAccount) {
                                SavingAccount savingAccount = (SavingAccount) account;
                                System.out.print("Do you want to calculate interest? (yes/no): ");
                                String interestChoice = scanner.next();
                                if (interestChoice.equalsIgnoreCase("yes")) {
                                    System.out.print("Enter number of months: ");
                                    int months = scanner.nextInt();
                                    savingAccount.calculateInterest(months);
                                }
                            }
                            break;
                        case 4:
                            exit = true;
                            System.out.println("Thank you for using the banking system!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
                scanner.close();
            }
        }



