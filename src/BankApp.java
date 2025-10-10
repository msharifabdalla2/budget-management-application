import java.util.InputMismatchException;
import java.util.Scanner;

public class  BankApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter account holder name: ");
        String name = scanner.nextLine();
        double initialBalance = readDouble("Enter initial balance: ");

        BankAccount account = new BankAccount(name, initialBalance);
        System.out.println("Welcome " + account.getAccountHolderName() + ". Your account balance is " + account.getBalance());

        boolean running = true;
        
        while (running) {
            printMenu();
            int choice = readInt("Choose an option:");

            switch (choice) {
                case 1 -> depositFunds(account);
                case 2 -> withdrawFunds(account);
                case 3 -> checkBalance(account);
                case 4 -> {
                    System.out.println("Thank you for using the bank app. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Please enter a valid option!");
                case 1:
                    depositFunds(account);
                    break;
                case 2:
                    withdrawFunds(account);
                    break;
                case 3:
                    checkBalance(account);
                    break;
                case 4:
                    System.out.println("Thank you for using the bank app. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Please enter a valid option!");
            }

            System.out.println( );
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=== Banking Menu ===");
        System.out.println("1) Deposit");
        System.out.println("2) Withdraw");
        System.out.println("3) Check Balance");
        System.out.println("4) Exit");
    }

    private static void depositFunds(BankAccount account) {
        double amount = readDouble("Enter deposit amount: ");
        account.deposit(amount);
    }

    private static void withdrawFunds(BankAccount account) {
        double amount = readDouble("Enter withdraw amount: ");
        account.withdraw(amount);
    }

    private static void checkBalance(BankAccount account) {
        System.out.println("Your account balance is " + account.getBalance());
    }

//    Helper input methods that handle invalid input
    private static int readInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value < 0 || value > 4) {
                    System.out.println("Please enter a valid number");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                scanner.nextLine();
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                if (value < 0) {
                    System.out.println("Please enter a positive number");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                scanner.nextLine();
            }
        }
    }
}