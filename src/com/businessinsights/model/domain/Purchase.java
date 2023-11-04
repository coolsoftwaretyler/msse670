package com.businessinsights.model.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a purchase event as provided from an in-app payments system.
 * Contains information about the user, the product purchased, transaction details, and more.
 */
public class Purchase {
    /** The user ID of the purchaser. Used to group purchases together by user. */
    private String rcOriginalAppUserId;

    /** The product identifier for the purchased product. */
    private String productIdentifier;

    /** The date and time when the purchase was made. */
    private Date startTime;

    /** Indicates whether the purchase was made as a trial. */
    private Boolean isTrialPeriod;

    /**
     * The revenue (converted to USD) generated from the transaction after accounting for full and partial refunds.
     * Can be null if product prices haven't been collected from the user's device.
     */
    private Float priceInUsd;

    /**
     * The gross revenue (converted to USD) generated from the transaction.
     * Remains set for refunded transactions. Can be null if product prices haven't been collected from the user's device.
     */
    private Float purchasePriceInUsd;

    /** The transaction identifier. Can be used as a unique identifier for the purchase. */
    private String storeTransactionId;

    /**
     * The transaction identifier of the first purchase or the original transaction.
     * Can be used to find all related transactions for a single subscription.
     */
    private String originalStoreTransactionId;

    /**
     * Represents the renewal number for subscriptions.
     * Always starts at 1, and trial conversions are counted as renewals.
     */
    private Integer renewalNumber;

    /** Indicates whether this transaction is a trial conversion. */
    private Boolean isTrialConversion;

    /**
     * The effective end time for the purchase.
     * Acts as a single reference point of a subscriber’s expiration and entitlement revocation.
     */
    private Date effectiveEndTime;

    /** Empty constructor */
    public Purchase() {
    }

    /** Constructor with all fields */
    public Purchase(String rcOriginalAppUserId, String productIdentifier, Date startTime, Boolean isTrialPeriod, Float priceInUsd, Float purchasePriceInUsd, String storeTransactionId, String originalStoreTransactionId, Integer renewalNumber, Boolean isTrialConversion, Date effectiveEndTime) {
        this.rcOriginalAppUserId = rcOriginalAppUserId;
        this.productIdentifier = productIdentifier;
        this.startTime = startTime;
        this.isTrialPeriod = isTrialPeriod;
        this.priceInUsd = priceInUsd;
        this.purchasePriceInUsd = purchasePriceInUsd;
        this.storeTransactionId = storeTransactionId;
        this.originalStoreTransactionId = originalStoreTransactionId;
        this.renewalNumber = renewalNumber;
        this.isTrialConversion = isTrialConversion;
        this.effectiveEndTime = effectiveEndTime;
    }

    /**
     * Retrieves the user ID of the purchaser.
     *
     * @return the user ID
     */
    public String getRcOriginalAppUserId() {
        return rcOriginalAppUserId;
    }

    /**
     * Sets the user ID of the purchaser.
     *
     * @param rcOriginalAppUserId the user ID
     */
    public void setRcOriginalAppUserId(String rcOriginalAppUserId) {
        this.rcOriginalAppUserId = rcOriginalAppUserId;
    }

    /**
     * Retrieves the product identifier.
     *
     * @return the product identifier
     */
    public String getProductIdentifier() {
        return productIdentifier;
    }

    /**
     * Sets the product identifier.
     *
     * @param productIdentifier the product identifier
     */
    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    /**
     * Retrieves the start time of the purchase.
     *
     * @return the start time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of the purchase.
     *
     * @param startTime the start time
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Checks if the purchase was made as a trial.
     *
     * @return true if it was a trial, false otherwise
     */
    public Boolean getIsTrialPeriod() {
        return isTrialPeriod;
    }

    /**
     * Sets the trial status of the purchase.
     *
     * @param isTrialPeriod true if it was a trial, false otherwise
     */
    public void setIsTrialPeriod(Boolean isTrialPeriod) {
        this.isTrialPeriod = isTrialPeriod;
    }

    /**
     * Retrieves the revenue generated from the purchase in USD.
     *
     * @return the revenue in USD
     */
    public Float getPriceInUsd() {
        return priceInUsd;
    }

    /**
     * Sets the revenue generated from the purchase in USD.
     *
     * @param priceInUsd the revenue in USD
     */
    public void setPriceInUsd(Float priceInUsd) {
        this.priceInUsd = priceInUsd;
    }

    /**
     * Retrieves the gross revenue generated from the purchase in USD.
     *
     * @return the gross revenue in USD
     */
    public Float getPurchasePriceInUsd() {
        return purchasePriceInUsd;
    }

    /**
     * Sets the gross revenue generated from the purchase in USD.
     *
     * @param purchasePriceInUsd the gross revenue in USD
     */
    public void setPurchasePriceInUsd(Float purchasePriceInUsd) {
        this.purchasePriceInUsd = purchasePriceInUsd;
    }

    /**
     * Retrieves the transaction identifier for the purchase.
     *
     * @return the transaction identifier
     */
    public String getStoreTransactionId() {
        return storeTransactionId;
    }

    /**
     * Sets the transaction identifier for the purchase.
     *
     * @param storeTransactionId the transaction identifier
     */
    public void setStoreTransactionId(String storeTransactionId) {
        this.storeTransactionId = storeTransactionId;
    }

    /**
     * Retrieves the original transaction identifier for the purchase.
     *
     * @return the original transaction identifier
     */
    public String getOriginalStoreTransactionId() {
        return originalStoreTransactionId;
    }

    /**
     * Sets the original transaction identifier for the purchase.
     *
     * @param originalStoreTransactionId the original transaction identifier
     */
    public void setOriginalStoreTransactionId(String originalStoreTransactionId) {
        this.originalStoreTransactionId = originalStoreTransactionId;
    }

    /**
     * Retrieves the renewal number for the purchase.
     *
     * @return the renewal number
     */
    public Integer getRenewalNumber() {
        return renewalNumber;
    }

    /**
     * Sets the renewal number for the purchase.
     *
     * @param renewalNumber the renewal number
     */
    public void setRenewalNumber(Integer renewalNumber) {
        this.renewalNumber = renewalNumber;
    }

    /**
     * Checks if the transaction was a trial conversion.
     *
     * @return true if it was a trial conversion, false otherwise
     */
    public Boolean getIsTrialConversion() {
        return isTrialConversion;
    }

    /**
     * Sets the trial conversion status of the purchase.
     *
     * @param isTrialConversion true if it was a trial conversion, false otherwise
     */
    public void setIsTrialConversion(Boolean isTrialConversion) {
        this.isTrialConversion = isTrialConversion;
    }

    /**
     * Retrieves the effective end time of the purchase.
     *
     * @return the effective end time
     */
    public Date getEffectiveEndTime() {
        return effectiveEndTime;
    }

    /**
     * Sets the effective end time of the purchase.
     *
     * @param effectiveEndTime the effective end time
     */
    public void setEffectiveEndTime(Date effectiveEndTime) {
        this.effectiveEndTime = effectiveEndTime;
    }

    /**
     * Validates the purchase object ensuring all required fields are set and valid.
     *
     * @throws IllegalStateException if any validation check fails
     */
    public void validate() throws IllegalStateException {
        if (storeTransactionId == null || storeTransactionId.trim().isEmpty()) {
            throw new IllegalStateException("Store Transaction ID cannot be null or empty");
        }
        if (rcOriginalAppUserId == null || rcOriginalAppUserId.trim().isEmpty()) {
            throw new IllegalStateException("Original App User ID cannot be null or empty");
        }
        if (productIdentifier == null || productIdentifier.trim().isEmpty()) {
            throw new IllegalStateException("Product Identifier cannot be null or empty");
        }
        if (startTime == null) {
            throw new IllegalStateException("Start Time cannot be null");
        }
        if (effectiveEndTime == null) {
            throw new IllegalStateException("Effective End Time cannot be null");
        }
        // Add any other required field validations as needed
    }

    /**
     * Compares this purchase object to another object.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return Objects.equals(storeTransactionId, purchase.storeTransactionId);
    }

    /**
     * Generates a hash code for this purchase object.
     *
     * @return a hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(storeTransactionId);
    }

    /**
     * Converts this purchase object to a string representation.
     *
     * @return a string representation of the purchase
     */
    @Override
    public String toString() {
        return "Purchase{" +
                "rcOriginalAppUserId='" + rcOriginalAppUserId + '\'' +
                ", productIdentifier='" + productIdentifier + '\'' +
                ", startTime=" + startTime +
                ", isTrialPeriod=" + isTrialPeriod +
                ", priceInUsd=" + priceInUsd +
                ", purchasePriceInUsd=" + purchasePriceInUsd +
                ", storeTransactionId='" + storeTransactionId + '\'' +
                ", originalStoreTransactionId='" + originalStoreTransactionId + '\'' +
                ", renewalNumber=" + renewalNumber +
                ", isTrialConversion=" + isTrialConversion +
                ", effectiveEndTime=" + effectiveEndTime +
                '}';
    }

    /**
     * Calculates the length of the subscription in days.
     *
     * @return the length of the subscription in days. If the subscription has no end date, it returns all the days including today.
     */
    public long lengthOfPurchase() {
        Date endDate = effectiveEndTime != null ? effectiveEndTime : new Date();
        long timeDifference = endDate.getTime() - startTime.getTime();
        return timeDifference / (1000 * 60 * 60 * 24);
    }

    /**
     * Determines if this is the first time purchase, meaning the user has actually paid money.
     * A trial event is not considered a first time purchase, but a trial conversion is.
     * If it's a first renewal with no prior trial, it is also considered a first time purchase.
     *
     * @return true if it's the first time purchase, false otherwise
     */
    public boolean isFirstTimePurchase() {
        // If it's a trial event, it's not a first time purchase
        if (isTrialPeriod != null && isTrialPeriod) {
            return false;
        }

        // If it's a trial conversion or a first renewal (renewalNumber == 1) with no prior trial, it's a first time purchase
        return isTrialConversion != null && isTrialConversion || renewalNumber != null && renewalNumber == 1;
    }

}
