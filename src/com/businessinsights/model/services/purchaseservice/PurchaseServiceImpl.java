package com.businessinsights.model.services.purchaseservice;

import com.businessinsights.model.domain.Purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PurchaseServiceImpl implements IPurchaseService {

    private final List<Purchase> purchases = new ArrayList<>(); // Temporary in-memory list

    @Override
    public Purchase createPurchase(Purchase purchase) {
        try {
            System.out.println("Creating a new purchase record for transaction ID: " + purchase.getStoreTransactionId());
            purchase.validate();
            purchases.add(purchase);
            return purchase;
        } catch (Exception e) {
            System.out.println("Failed to create Purchase: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Purchase getPurchaseByTransactionId(String transactionId) {
        try {
            System.out.println("Retrieving a DailyAdSpend record by date from the database");

            return purchases.stream()
                    .filter(p -> transactionId.equals(p.getStoreTransactionId()))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("Failed to retrieve Purchase: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Purchase> getPurchasesByUserId(String userId) {
        try {
            System.out.println("Retrieving all DailyAdSpend records from the database");
            return purchases.stream()
                    .filter(p -> userId.equals(p.getRcOriginalAppUserId()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Failed to retrieve all DailyAdSpends: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Purchase updatePurchase(Purchase purchase) {
        try {
            System.out.println("Updating an existing Purchase record in the database");
            purchase.validate();

            Optional<Purchase> existingPurchase = purchases.stream()
                    .filter(p -> p.getStoreTransactionId().equals(purchase.getStoreTransactionId()))
                    .findFirst();

            if (existingPurchase.isPresent()) {
                Purchase toUpdate = existingPurchase.get();
                // No need to set the transaction id, since we know it matches
                toUpdate.setRcOriginalAppUserId(purchase.getRcOriginalAppUserId());
                toUpdate.setProductIdentifier(purchase.getProductIdentifier());
                toUpdate.setStartTime(purchase.getStartTime());
                toUpdate.setIsTrialPeriod(purchase.getIsTrialPeriod());
                toUpdate.setPriceInUsd(purchase.getPriceInUsd());
                toUpdate.setPurchasePriceInUsd(purchase.getPurchasePriceInUsd());
                toUpdate.setOriginalStoreTransactionId(purchase.getOriginalStoreTransactionId());
                toUpdate.setRenewalNumber(purchase.getRenewalNumber());
                toUpdate.setIsTrialConversion(purchase.getIsTrialConversion());
                toUpdate.setEffectiveEndTime(purchase.getEffectiveEndTime());

                System.out.println("Purchase record updated for id: " + toUpdate.getStoreTransactionId());
                return toUpdate;
            } else {
                System.out.println("No Purchase record found for date: " + purchase.getStoreTransactionId());
                return null;
            }
        } catch (Exception e) {
            System.out.println("Failed to update Purchase: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deletePurchase(String transactionId) {
        try {
            System.out.println("Deleting a Purchase record by date from the database");

            return purchases.removeIf(p -> transactionId.equals(p.getStoreTransactionId()));
        } catch (Exception e) {
            System.out.println("Failed to delete Purchase: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Purchase> listAllPurchases() {
        try {
            System.out.println("Retrieving all Purchase records from the database");
            return new ArrayList<>(purchases);
        } catch (Exception e) {
            System.out.println("Failed to retrieve all Purchase: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
