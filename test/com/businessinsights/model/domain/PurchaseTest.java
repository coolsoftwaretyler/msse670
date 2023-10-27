package com.businessinsights.model.domain;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {

    @Test
    void testGettersAndSetters() {
        Purchase purchase = new Purchase();
        String userId = "user123";
        String productId = "product123";
        Date startTime = new Date();
        Boolean isTrial = true;
        Float priceUSD = 10.0f;
        Float purchasePriceUSD = 12.0f;
        String transactionId = "trans123";
        String originalTransactionId = "trans124";
        Integer renewalNumber = 1;
        Boolean isTrialConversion = true;
        Date effectiveEndTime = new Date();

        purchase.setRcOriginalAppUserId(userId);
        purchase.setProductIdentifier(productId);
        purchase.setStartTime(startTime);
        purchase.setIsTrialPeriod(isTrial);
        purchase.setPriceInUsd(priceUSD);
        purchase.setPurchasePriceInUsd(purchasePriceUSD);
        purchase.setStoreTransactionId(transactionId);
        purchase.setOriginalStoreTransactionId(originalTransactionId);
        purchase.setRenewalNumber(renewalNumber);
        purchase.setIsTrialConversion(isTrialConversion);
        purchase.setEffectiveEndTime(effectiveEndTime);

        assertEquals(userId, purchase.getRcOriginalAppUserId());
        assertEquals(productId, purchase.getProductIdentifier());
        assertEquals(startTime, purchase.getStartTime());
        assertEquals(isTrial, purchase.getIsTrialPeriod());
        assertEquals(priceUSD, purchase.getPriceInUsd());
        assertEquals(purchasePriceUSD, purchase.getPurchasePriceInUsd());
        assertEquals(transactionId, purchase.getStoreTransactionId());
        assertEquals(originalTransactionId, purchase.getOriginalStoreTransactionId());
        assertEquals(renewalNumber, purchase.getRenewalNumber());
        assertEquals(isTrialConversion, purchase.getIsTrialConversion());
        assertEquals(effectiveEndTime, purchase.getEffectiveEndTime());
    }

    @Test
    void testValidate() {
        Purchase purchase = new Purchase();
        Exception exception = assertThrows(IllegalStateException.class, purchase::validate);
        String expectedMessage = "Store Transaction ID cannot be null or empty";
        assertTrue(exception.getMessage().contains(expectedMessage));

        purchase.setStoreTransactionId("trans123");
        exception = assertThrows(IllegalStateException.class, purchase::validate);
        expectedMessage = "Original App User ID cannot be null or empty";
        assertTrue(exception.getMessage().contains(expectedMessage));

        purchase.setRcOriginalAppUserId("user123");
        exception = assertThrows(IllegalStateException.class, purchase::validate);
        expectedMessage = "Product Identifier cannot be null or empty";
        assertTrue(exception.getMessage().contains(expectedMessage));

        purchase.setProductIdentifier("product123");
        exception = assertThrows(IllegalStateException.class, purchase::validate);
        expectedMessage = "Start Time cannot be null";
        assertTrue(exception.getMessage().contains(expectedMessage));

        purchase.setStartTime(new Date());
        exception = assertThrows(IllegalStateException.class, purchase::validate);
        expectedMessage = "Effective End Time cannot be null";
        assertTrue(exception.getMessage().contains(expectedMessage));

        purchase.setEffectiveEndTime(new Date());
        assertDoesNotThrow(purchase::validate);
    }

    @Test
    void testEqualsAndHashCode() {
        Purchase purchase1 = new Purchase();
        purchase1.setStoreTransactionId("trans123");

        Purchase purchase2 = new Purchase();
        purchase2.setStoreTransactionId("trans123");

        Purchase purchase3 = new Purchase();
        purchase3.setStoreTransactionId("trans124");

        assertEquals(purchase1, purchase2);
        assertNotEquals(purchase1, purchase3);

        assertEquals(purchase1.hashCode(), purchase2.hashCode());
        assertNotEquals(purchase1.hashCode(), purchase3.hashCode());
    }

    @Test
    void testToString() {
        Purchase purchase = new Purchase();
        purchase.setRcOriginalAppUserId("user123");
        purchase.setProductIdentifier("product123");
        purchase.setStartTime(new Date());
        purchase.setIsTrialPeriod(true);
        purchase.setPriceInUsd(10.0f);
        purchase.setPurchasePriceInUsd(12.0f);
        purchase.setStoreTransactionId("trans123");
        purchase.setOriginalStoreTransactionId("trans124");
        purchase.setRenewalNumber(1);
        purchase.setIsTrialConversion(true);
        purchase.setEffectiveEndTime(new Date());

        String toStringResult = purchase.toString();
        assertTrue(toStringResult.contains("user123"));
        assertTrue(toStringResult.contains("product123"));
        assertTrue(toStringResult.contains("trans123"));
    }

    @Test
    void testLengthOfPurchase() {
        Purchase purchase = new Purchase();
        Date startTime = new Date();
        purchase.setStartTime(startTime);

        // If effective end time is not set, should return 0 as the subscription includes today.
        assertEquals(0, purchase.lengthOfPurchase());

        Date oneDayLater = new Date(startTime.getTime() + (1000 * 60 * 60 * 24));
        purchase.setEffectiveEndTime(oneDayLater);
        assertEquals(1, purchase.lengthOfPurchase());
    }

    @Test
    void testIsFirstTimePurchase() {
        Purchase purchase = new Purchase();

        // Trial period, not a first time purchase
        purchase.setIsTrialPeriod(true);
        assertFalse(purchase.isFirstTimePurchase());

        // Trial conversion, is a first time purchase
        purchase.setIsTrialPeriod(false);
        purchase.setIsTrialConversion(true);
        assertTrue(purchase.isFirstTimePurchase());

        // First renewal without a prior trial, is a first time purchase
        purchase.setIsTrialConversion(false);
        purchase.setRenewalNumber(1);
        assertTrue(purchase.isFirstTimePurchase());

        // Second renewal, not a first time purchase
        purchase.setRenewalNumber(2);
        assertFalse(purchase.isFirstTimePurchase());
    }
}
