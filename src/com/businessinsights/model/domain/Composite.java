package com.businessinsights.model.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a composite class that aggregates different types of business data.
 */
public class Composite {
    /** An array of DailyAdSpend objects representing daily advertisement expenditures. */
    private DailyAdSpend[] dailyAdSpends;

    /** An array of Report objects representing business reports. */
    private Report[] reports;

    /** An array of Purchase objects representing purchases. */
    private Purchase[] purchases;

    /**
     * Retrieves the array of daily advertisement expenditures.
     *
     * @return an array of DailyAdSpend objects
     */
    public DailyAdSpend[] getDailyAdSpends() {
        return dailyAdSpends;
    }

    /**
     * Sets the array of daily advertisement expenditures.
     *
     * @param dailyAdSpends an array of DailyAdSpend objects
     */
    public void setDailyAdSpends(DailyAdSpend[] dailyAdSpends) {
        this.dailyAdSpends = dailyAdSpends;
    }

    /**
     * Retrieves the array of business reports.
     *
     * @return an array of Report objects
     */
    public Report[] getReports() {
        return reports;
    }

    /**
     * Sets the array of business reports.
     *
     * @param reports an array of Report objects
     */
    public void setReports(Report[] reports) {
        this.reports = reports;
    }

    /**
     * Retrieves the array of purchases.
     *
     * @return an array of Purchase objects
     */
    public Purchase[] getPurchases() {
        return purchases;
    }

    /**
     * Sets the array of purchases.
     *
     * @param purchases an array of Purchase objects
     */
    public void setPurchases(Purchase[] purchases) {
        this.purchases = purchases;
    }

    /**
     * Validates the composite object ensuring all required fields are set and valid.
     *
     * @throws IllegalStateException if any validation check fails
     */
    public void validate() throws IllegalStateException {
        if (dailyAdSpends != null) {
            for (DailyAdSpend dailyAdSpend : dailyAdSpends) {
                if (dailyAdSpend == null) {
                    throw new IllegalStateException("Daily Ad Spend cannot be null");
                }
                dailyAdSpend.validate();
            }
        }

        if (reports != null) {
            for (Report report : reports) {
                if (report == null) {
                    throw new IllegalStateException("Report cannot be null");
                }
                report.validate();
            }
        }

        if (purchases != null) {
            for (Purchase purchase : purchases) {
                if (purchase == null) {
                    throw new IllegalStateException("Purchase cannot be null");
                }
                purchase.validate();
            }
        }
    }

    public void generateReport() {
        if (dailyAdSpends != null && purchases != null) {
            for (DailyAdSpend dailyAdSpend : dailyAdSpends) {
                float totalSpent = dailyAdSpend.getAmountSpent();
                float totalEarned = 0;

                for (Purchase purchase : purchases) {
                    if (purchase != null) {
                        totalEarned += purchase.getPurchasePriceInUsd();
                    }
                }

                float profit = totalEarned - totalSpent;
                String title = generateDateRangeTitle(dailyAdSpend.getDate().toString());

                Report profitReport = new Report();
                profitReport.setTitle(title);
                profitReport.setDescription("Profit: " + profit);
                profitReport.setEndDate(new Date());
                profitReport.setStartDate(dailyAdSpend.getDate());

                addReport(profitReport);
            }
        }
    }

    private String generateDateRangeTitle(String date) {
        return "Date: " + date;
    }

    private void addReport(Report report) {
        if (reports == null) {
            reports = new Report[]{report};
        } else {
            int currentLength = reports.length;
            Report[] updatedReports = new Report[currentLength + 1];
            System.arraycopy(reports, 0, updatedReports, 0, currentLength);
            updatedReports[currentLength] = report;
            reports = updatedReports;
        }
    }
}
