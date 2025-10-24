package com.mycompany.budgetapp.app;

import com.mycompany.budgetapp.service.BudgetManager;

public class Main {
    public static void main(String[] args) {
        BudgetManager manager = new BudgetManager();
        manager.run();
    }
}
