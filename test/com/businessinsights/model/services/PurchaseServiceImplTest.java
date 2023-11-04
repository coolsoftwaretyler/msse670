package com.businessinsights.model.services;

import com.businessinsights.model.domain.Purchase;
import com.businessinsights.model.services.purchaseservice.PurchaseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseServiceImplTest {

    private PurchaseServiceImpl service;
    private Purchase testPurchase;

    @BeforeEach
    void setUp() {
        service = new PurchaseServiceImpl();
        // Initialize a test purchase object before each test
        testPurchase = new Purchase(
                "user123",
                "com.example.product1",
                new Date(),
                true,
                9.99f,
                7.99f,
                "TXN12345",
                "OTXN12345",
                1,
                false,
                new Date()
        );
    }

    @Test
    void createPurchase() {
        Purchase created = service.createPurchase(testPurchase);
        assertNotNull(created, "Purchase creation should return the created purchase object.");
        assertEquals(testPurchase, created, "The returned purchase should be the same as the created one.");
    }

    @Test
    void getPurchaseByTransactionId() {
        service.createPurchase(testPurchase);
        Purchase found = service.getPurchaseByTransactionId("TXN12345");
        assertNotNull(found, "Should return a purchase when searched by a valid transaction ID.");
        assertEquals("TXN12345", found.getStoreTransactionId(), "Transaction ID should match the one searched for.");
    }

    @Test
    void getPurchasesByUserId() {
        service.createPurchase(testPurchase);
        List<Purchase> purchasesByUser = service.getPurchasesByUserId("user123");
        assertFalse(purchasesByUser.isEmpty(), "Should return at least one purchase for the given user ID.");
        assertEquals("user123", purchasesByUser.get(0).getRcOriginalAppUserId(), "User ID should match the one in the search query.");
    }

    @Test
    void updatePurchase() {
        service.createPurchase(testPurchase);
        // Modify some attribute of the purchase, like price
        testPurchase.setPriceInUsd(11.99f);
        Purchase updated = service.updatePurchase(testPurchase);
        assertNotNull(updated, "Updating should return the updated purchase object.");
        assertEquals(11.99f, updated.getPriceInUsd(), "Price should be updated to the new value.");
    }

    @Test
    void deletePurchase() {
        service.createPurchase(testPurchase);
        boolean deleted = service.deletePurchase("TXN12345");
        assertTrue(deleted, "Should return true when a purchase is successfully deleted.");
        assertNull(service.getPurchaseByTransactionId("TXN12345"), "Deleted purchase should no longer be retrievable.");
    }

    @Test
    void listAllPurchases() {
        service.createPurchase(testPurchase);
        List<Purchase> allPurchases = service.listAllPurchases();
        assertFalse(allPurchases.isEmpty(), "Should return a list of all purchases.");
        assertTrue(allPurchases.contains(testPurchase), "The list should contain the created purchase.");
    }
}
