import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BudgetManager {
    private Scanner scanner = new Scanner(System.in);
    private List<BudgetEntry> entries = new ArrayList<>();

    public void run() {
        System.out.println("Welcome to the budget manager");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> addEntry();
                case 2 -> viewEntries();
                case 3 -> viewTotalBalance();
                case 4 -> {
                    System.out.println("Thank you for using our budget manager! Goodbye!");
                    running = false;
                }
                default -> System.out.println("Please choose a valid option!");
            }
            System.out.println();
        }
        scanner.close();
    }

    // Budget Manager operations (methods)
    public void printMenu() {
        System.out.println("=== Budget Manager ===");
        System.out.println("1) Add Budget Entry");
        System.out.println("2) View All Budget Entries");
        System.out.println("3) View Total Balance");
        System.out.println("4) Exit");
    }

    public void addEntry() {
        System.out.println("Enter category: ");
        String category = scanner.nextLine();
        double amount = readDouble("Enter amount: ");
        System.out.println("Enter type (income/expense): ");
        String type = scanner.nextLine();

        try {
            BudgetEntry entry = new BudgetEntry(category, amount, type);
            entries.add(entry);
            System.out.println("Entry added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewEntries() {
        if (entries.isEmpty()) {
            System.out.println("No entries found!");
            return;
        }
        System.out.println("=== All Budget Entries ===");
        for (BudgetEntry entry : entries) {
            System.out.println(entry.getCategory() + " - " + entry.getType() + " - £" + entry.getAmount());
        }
    }

    public void viewTotalBalance() {
        double balance = 0;
        for (BudgetEntry entry : entries) {
            if (entry.getType().equals("income")) {
                balance += entry.getAmount();
            } else {
                balance -= entry.getAmount();
            }
        }
        System.out.println("Your total balance is £" + balance);
    }

    // Helper input methods
    public int readInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value < 0  || value > 4) {
                    System.out.println("Invalid option. Please try again.");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid option. Please try again.");
                scanner.nextLine();
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                if (value < 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid option. Please try again.");
                scanner.nextLine();
            }
        }
    }
}
