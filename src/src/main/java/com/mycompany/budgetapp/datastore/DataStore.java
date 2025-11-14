package com.mycompany.budgetapp.datastore;

import com.mycompany.budgetapp.model.BudgetEntry;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public static List<BudgetEntry> loadSampleData() {
        List<BudgetEntry> data = new ArrayList<>();
        data.add(new BudgetEntry("Salary", 2500.00, "Income"));
        data.add(new BudgetEntry("Rent", 1000, "Expense"));
        data.add(new BudgetEntry("Groceries", 300, "Expense"));
        data.add(new BudgetEntry("Investment", 200, "Income"));
        return data;
    }
}
