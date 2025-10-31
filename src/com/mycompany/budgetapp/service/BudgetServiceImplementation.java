package com.mycompany.budgetapp.service;

import com.mycompany.budgetapp.model.BudgetEntry;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BudgetServiceImplementation implements BudgetService {
    private List<BudgetEntry> entries = new ArrayList<>();

    @Override
    public void addEntry(BudgetEntry entry) {
        entries.add(entry);
    }

    @Override
    public double getTotalBalance() {
        double balance = 0;
        for (BudgetEntry entry : entries) {
            if (entry.getType().equalsIgnoreCase("income")) {
                balance += entry.getAmount();
            } else {
                balance -= entry.getAmount();
            }
        }
        return balance;
    }

    @Override
    public List<BudgetEntry> getAllEntriesSortedByAmount() {
        List<BudgetEntry> sorted = new ArrayList<>(entries);
        Collections.sort(sorted, Collections.reverseOrder());
        return sorted;
    }

    @Override
    public void searchByEntryType(String entryType) {
        entries.stream()
                .filter(entry -> entry.getType().equalsIgnoreCase(entryType))
                .forEach(entry -> System.out.println("Category: " + entry.getCategory() + ", Amount: " + entry.getAmount() + ", Type: " + entry.getType()));
        }
    }
