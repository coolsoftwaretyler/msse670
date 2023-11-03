package com.businessinsights.model.services;

import com.businessinsights.model.domain.DailyAdSpend;
import com.businessinsights.model.services.dailyadspendservice.DailyAdSpendServiceImpl;
import com.businessinsights.model.services.dailyadspendservice.IDailyAdSpendService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DailyAdSpendServiceImplTest {

    private IDailyAdSpendService service;
    private DailyAdSpend dailyAdSpend;
    private Date testDate;

    @BeforeEach
    void setUp() {
        // Initialize the service before each test
        service = new DailyAdSpendServiceImpl();
        // Create a date for testing
        testDate = new Date();
        // Create a DailyAdSpend instance for testing
        dailyAdSpend = new DailyAdSpend(testDate, 100.0f, "GoogleAds");
    }

    @Test
    void createDailyAdSpend_ShouldReturnCreatedObject() {
        DailyAdSpend created = service.createDailyAdSpend(dailyAdSpend);
        assertNotNull(created, "The created DailyAdSpend should not be null.");
        assertEquals(dailyAdSpend, created, "The created DailyAdSpend should match the one provided.");
    }

    @Test
    void getDailyAdSpendByDate_ShouldReturnCorrectObject() {
        service.createDailyAdSpend(dailyAdSpend);
        DailyAdSpend found = service.getDailyAdSpendByDate(testDate);
        assertNotNull(found, "A DailyAdSpend should be found by its date.");
        assertEquals(dailyAdSpend, found, "The found DailyAdSpend should match the created one.");
    }

    @Test
    void updateDailyAdSpend_ShouldUpdateCorrectly() {
        service.createDailyAdSpend(dailyAdSpend);
        dailyAdSpend.setAmountSpent(200.0f);
        DailyAdSpend updated = service.updateDailyAdSpend(dailyAdSpend);
        assertNotNull(updated, "The updated DailyAdSpend should not be null.");
        assertEquals(200.0f, updated.getAmountSpent(), "The amount spent should be updated.");
    }

    @Test
    void deleteDailyAdSpend_ShouldDeleteCorrectly() {
        service.createDailyAdSpend(dailyAdSpend);
        boolean deleted = service.deleteDailyAdSpend(testDate);
        assertTrue(deleted, "The DailyAdSpend should be deleted.");
        assertNull(service.getDailyAdSpendByDate(testDate), "The DailyAdSpend should no longer be retrievable.");
    }

    @Test
    void getAllDailyAdSpends_ShouldReturnAllRecords() {
        service.createDailyAdSpend(dailyAdSpend);
        DailyAdSpend anotherAdSpend = new DailyAdSpend(new Date(testDate.getTime() + 86400000), 150.0f, "FacebookAds");
        service.createDailyAdSpend(anotherAdSpend);
        assertEquals(2, service.getAllDailyAdSpends().size(), "There should be two DailyAdSpends returned.");
    }

    @Test
    void createDailyAdSpend_WithInvalidData_ShouldHandleErrorGracefully() {
        DailyAdSpend invalidAdSpend = new DailyAdSpend(null, -100.0f, null);
        assertThrows(IllegalStateException.class, invalidAdSpend::validate, "Should throw IllegalStateException due to invalid data.");
        assertNull(service.createDailyAdSpend(invalidAdSpend), "Should return null due to invalid input.");
    }
}
