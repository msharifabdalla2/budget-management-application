package com.mycompany.budgetapp.service;

import com.mycompany.budgetapp.model.BudgetEntry;

import java.util.List;

public interface BudgetService {
    void addEntry(BudgetEntry entry);
    double getTotalBalance();
}
