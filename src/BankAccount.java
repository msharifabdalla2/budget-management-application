public class BankAccount {
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive");
            return;
        }
        balance += amount;
        System.out.println("Successfully deposited " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive");
            return;
        }
        else if (amount > balance) {
            System.out.println("Insufficient balance");
        }
        else {
            balance -= amount;
            System.out.println("Successfully withdrew " + amount);
        }
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
