package com.mycompany.budgetapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BudgetEntryTest {

    @Test
    void validBudgetEntryShouldBeCreated() {
        BudgetEntry entry = new BudgetEntry("Food", 50.0, "Expense");
        assertEquals("Food", entry.getCategory());
        assertEquals(50.0, entry.getAmount());
        assertEquals("Expense", entry.getType());
    }

    @Test
    void invalidNegativeAmountShouldThrow() {
        assertThrows(IllegalArgumentException.class,
                () -> new BudgetEntry("Food", -10.0, "Expense"));
    }

    @Test
    void invalidTypeShouldThrow() {
        assertThrows(IllegalArgumentException.class,
                () -> new BudgetEntry("Food", 50.0, "wrongtype"));
    }

    @Test
    void compareToShouldSortByAmountAscending() {
        BudgetEntry a = new BudgetEntry("A", 10, "Income");
        BudgetEntry b = new BudgetEntry("B", 20, "Income");
        assertTrue(a.compareTo(b) < 0);
    }
}
