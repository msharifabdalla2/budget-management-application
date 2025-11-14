package com.mycompany.budgetapp.service;

import com.mycompany.budgetapp.model.BudgetEntry;

import java.util.List;

public interface BudgetService {
    void addEntry(BudgetEntry entry);
    double getTotalBalance();
    List<BudgetEntry> getAllEntriesSortedByAmount();
    void searchByEntryType(String category);
    List<BudgetEntry> searchByEntryTypeReturn(String entryType);

}
