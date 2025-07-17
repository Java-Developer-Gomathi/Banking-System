import java.util.Scanner;

class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public BankAccount(String name, String accNumber) {
        this.accountHolderName = name;
        this.accountNumber = accNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully!");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\n==== Banking System ====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    if (account == null) {
                        System.out.print("Enter account holder name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter account number: ");
                        String accNumber = scanner.nextLine();
                        account = new BankAccount(name, accNumber);
                        System.out.println("Account created successfully!");
                    } else {
                        System.out.println("Account already exists!");
                    }
                    break;
                case 2:
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ₹");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ₹");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        account.checkBalance();
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the Banking System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
