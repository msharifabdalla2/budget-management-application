package com.mycompany.budgetapp.service;

import com.mycompany.budgetapp.model.BudgetEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BudgetServiceImplementationTest {

    private BudgetServiceImplementation service;

    @BeforeEach
    void setup() {
        service = new BudgetServiceImplementation();
    }

    @Test
    void addingEntriesShouldIncreaseStoredSize() {
        service.addEntry(new BudgetEntry("Food", 30, "Expense"));
        assertEquals(1, service.getAllEntriesSortedByAmount().size());
    }

    @Test
    void totalBalanceShouldCalculateCorrectly() {
        service.addEntry(new BudgetEntry("Salary", 1000, "Income"));
        service.addEntry(new BudgetEntry("Rent", 500, "Expense"));
        assertEquals(500, service.getTotalBalance());
    }

    @Test
    void getAllEntriesSortedByAmountShouldSortDescending() {
        BudgetEntry low = new BudgetEntry("A", 10, "Expense");
        BudgetEntry high = new BudgetEntry("B", 100, "Income");

        service.addEntry(low);
        service.addEntry(high);

        List<BudgetEntry> result = service.getAllEntriesSortedByAmount();
        assertEquals(high, result.get(0));
        assertEquals(low, result.get(1));
    }

    @Test
    void searchByEntryTypeShouldReturnCorrectEntries() {
        service.addEntry(new BudgetEntry("Salary", 2000, "Income"));
        service.addEntry(new BudgetEntry("Rent", 800, "Expense"));

        List<BudgetEntry> found = service.searchByEntryTypeReturn("Income");
        assertEquals(1, found.size());
        assertEquals("Salary", found.get(0).getCategory());
    }
}
