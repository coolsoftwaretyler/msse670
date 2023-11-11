package com.businessinsights.model.services.purchaseservice;

import com.businessinsights.model.domain.Purchase;
import com.businessinsights.model.services.IService;

import java.util.List;

public interface IPurchaseService extends IService {
    /**
     * Creates a new purchase record.
     *
     * @param purchase The Purchase object to create.
     * @return the purchase instance created
     */
    Purchase createPurchase(Purchase purchase);

    /**
     * Retrieves a purchase record by its transaction ID.
     *
     * @param transactionId The transaction ID of the purchase.
     * @return The Purchase object.
     */
    Purchase getPurchaseByTransactionId(String transactionId);

    /**
     * Retrieves all purchases made by a specific user.
     *
     * @param userId The user ID of the purchaser.
     * @return A list of Purchase objects.
     */
    List<Purchase> getPurchasesByUserId(String userId);

    /**
     * Updates an existing purchase record.
     *
     * @param purchase The Purchase object to update.
     */
    Purchase updatePurchase(Purchase purchase);

    /**
     * Deletes a purchase record by its transaction ID.
     *
     * @param transactionId The transaction ID of the purchase.
     * @return if the Purchase was successfully deleted.
     */
    boolean deletePurchase(String transactionId);

    /**
     * Lists all purchase records.
     *
     * @return A list of all Purchase objects.
     */
    List<Purchase> listAllPurchases();
}
