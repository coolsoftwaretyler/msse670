package com.businessinsights.model.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Represents daily spending on advertisements.
 * Contains information about the date, amount spent, and the platform where the ads were displayed.
 */
public class DailyAdSpend {
    /** The date of the advertisement spending. */
    private Date date;

    /** The amount spent on advertisements for the day. */
    private Float amountSpent;

    /** The platform where the advertisements were displayed. Should be converted to an enum in future. */
    private String platform;

    /** Empty constructor */
    public DailyAdSpend() {}

    /** Constructor with all fields */
    public DailyAdSpend(Date date, Float amountSpent, String platform) {
        this.date = date;
        this.amountSpent = amountSpent;
        this.platform = platform;
    }

    /**
     * Retrieves the date of the advertisement spending.
     *
     * @return the date of the advertisement spending
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the advertisement spending.
     *
     * @param date the date of the advertisement spending
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Retrieves the amount spent on advertisements for the day.
     *
     * @return the amount spent
     */
    public Float getAmountSpent() {
        return amountSpent;
    }

    /**
     * Sets the amount spent on advertisements for the day.
     *
     * @param amountSpent the amount spent
     */
    public void setAmountSpent(Float amountSpent) {
        this.amountSpent = amountSpent;
    }

    /**
     * Retrieves the platform where the advertisements were displayed.
     *
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the platform where the advertisements were displayed.
     *
     * @param platform the platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * Converts the daily advertisement spending information to a string format.
     *
     * @return a string representation of the daily advertisement spending
     */
    @Override
    public String toString() {
        return "DailyAdSpend{" +
                "date=" + date +
                ", amountSpent=" + amountSpent +
                ", platform='" + platform + '\'' +
                '}';
    }

    /**
     * Compares this daily advertisement spending object to another object.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyAdSpend that = (DailyAdSpend) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(amountSpent, that.amountSpent) &&
                Objects.equals(platform, that.platform);
    }

    /**
     * Generates a hash code for this daily advertisement spending object.
     *
     * @return a hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(date, amountSpent, platform);
    }

    /**
     * Validates the daily advertisement spending object ensuring all required fields are set and valid.
     *
     * @throws IllegalStateException if any validation check fails
     */
    public void validate() throws IllegalStateException {
        if (date == null) {
            throw new IllegalStateException("Date cannot be null");
        }
        if (amountSpent == null) {
            throw new IllegalStateException("Amount spent cannot be null");
        }
        if (!validateAmountSpent()) {
            throw new IllegalStateException("Amount spent must be a positive value with up to two decimal places");
        }
        if (platform == null || platform.trim().isEmpty()) {
            throw new IllegalStateException("Platform cannot be null or empty");
        }
    }

    /**
     * Validates the amount spent ensuring it is a positive value with up to two decimal places.
     *
     * @return true if the amount spent is valid, false otherwise
     */
    private boolean validateAmountSpent() {
        if (amountSpent == null || amountSpent < 0) return false;
        String amountStr = Float.toString(amountSpent);
        int decimalIndex = amountStr.indexOf('.');
        return decimalIndex == -1 || decimalIndex + 3 >= amountStr.length();
    }
}
