public class BudgetEntry {
    private String category; // e.g. "Food", "Transport", "Salary"
    private double amount;
    private String type; // "Income" or "Expense"

    public BudgetEntry(String category, double amount, String type) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category cannot be blank");
        }
        if (type == null || !type.equalsIgnoreCase("Income") && !type.equalsIgnoreCase("Expense")) {
            throw new IllegalArgumentException("Type must be 'Income' or 'Expense'");
        }
        this.category = category;
        this.amount = amount;
        this.type = type;
    }

    // Getters
    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    // Setters with validation
    public void setCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category cannot be blank");
        }
        this.category = category;
    }

    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be less than zero");
        }
        this.amount = amount;
    }

    public void setType(String type) {
        if (!type.equalsIgnoreCase("income") && !type.equalsIgnoreCase("expense")) {
            throw new IllegalArgumentException("Type must be 'Income' or 'Expense");
        }
        this.type = type;
    }
}
