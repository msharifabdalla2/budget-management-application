package com.mycompany.budgetapp.datastore;

import com.mycompany.budgetapp.model.BudgetEntry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataStoreTest {

    @Test
    void sampleDataShouldLoadCorrectly() {
        List<BudgetEntry> data = DataStore.loadSampleData();
        assertEquals(4, data.size());
        assertEquals("Salary", data.get(0).getCategory());
    }
}
