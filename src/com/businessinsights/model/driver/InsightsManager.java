package com.businessinsights.model.driver;

import com.businessinsights.model.domain.DailyAdSpend;
import com.businessinsights.model.domain.Purchase;
import com.businessinsights.model.domain.Report;
import com.businessinsights.model.services.dailyadspendservice.DailyAdSpendServiceImpl;
import com.businessinsights.model.services.dailyadspendservice.IDailyAdSpendService;
import com.businessinsights.model.services.purchaseservice.PurchaseServiceImpl;
import com.businessinsights.model.services.purchaseservice.IPurchaseService;
import com.businessinsights.model.services.reportservice.ReportServiceImpl;
import com.businessinsights.model.services.reportservice.IReportService;

import java.util.List;
import java.util.Date;

public class InsightsManager {
    private final IDailyAdSpendService dailyAdSpendService;
    private final IPurchaseService purchaseService;
    private final IReportService reportService;

    public InsightsManager() {
        this.dailyAdSpendService = new DailyAdSpendServiceImpl();
        this.purchaseService = new PurchaseServiceImpl();
        this.reportService = new ReportServiceImpl();
    }

    public DailyAdSpend createDailyAdSpend(DailyAdSpend dailyAdSpend) {
        return dailyAdSpendService.createDailyAdSpend(dailyAdSpend);
    }

    public DailyAdSpend getDailyAdSpendByDate(Date date) {
        return dailyAdSpendService.getDailyAdSpendByDate(date);
    }

    public DailyAdSpend updateDailyAdSpend(DailyAdSpend dailyAdSpend) {
        return dailyAdSpendService.updateDailyAdSpend(dailyAdSpend);
    }

    public boolean deleteDailyAdSpend(Date date) {
        return dailyAdSpendService.deleteDailyAdSpend(date);
    }

    public List<DailyAdSpend> getAllDailyAdSpends() {
        return dailyAdSpendService.getAllDailyAdSpends();
    }

    // Methods for PurchaseService
    public Purchase createPurchase(Purchase purchase) {
        return purchaseService.createPurchase(purchase);
    }

    public Purchase getPurchaseByTransactionId(String transactionId) {
        return purchaseService.getPurchaseByTransactionId(transactionId);
    }

    public List<Purchase> getPurchasesByUserId(String userId) {
        return purchaseService.getPurchasesByUserId(userId);
    }

    public Purchase updatePurchase(Purchase purchase) {
        return purchaseService.updatePurchase(purchase);
    }

    public boolean deletePurchase(String transactionId) {
        return purchaseService.deletePurchase(transactionId);
    }

    public List<Purchase> listAllPurchases() {
        return purchaseService.listAllPurchases();
    }

    public Report createReport(Report report) {
        return reportService.createReport(report);
    }

    public Report getReportByTitle(String title) {
        return reportService.getReportByTitle(title);
    }

    public List<Report> getReportsByType(String reportType) {
        return reportService.getReportsByType(reportType);
    }

    public void updateReport(Report report) {
        reportService.updateReport(report);
    }

    public void deleteReport(String title) {
        reportService.deleteReport(title);
    }

    public List<Report> listAllReports() {
        return reportService.listAllReports();
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        InsightsManager manager = new InsightsManager();

        // Example usage of the InsightsManager
        // Create a new DailyAdSpend instance (assuming DailyAdSpend has an appropriate constructor)
        DailyAdSpend newSpend = new DailyAdSpend();

        // Create a new DailyAdSpend record
        DailyAdSpend createdSpend = manager.createDailyAdSpend(newSpend);

        // Get a DailyAdSpend record by date
        Date date = new Date();
        DailyAdSpend spendByDate = manager.getDailyAdSpendByDate(date);

        // Update a DailyAdSpend record
        DailyAdSpend updatedSpend = manager.updateDailyAdSpend(newSpend);

        // Delete a DailyAdSpend record
        boolean isDeleted = manager.deleteDailyAdSpend(date);

        // Retrieve all DailyAdSpend records
        List<DailyAdSpend> allSpends = manager.getAllDailyAdSpends();

        // Example usage of the InsightsManager for PurchaseService
        // Create a new Purchase instance
        Date startTime = new Date();
        Date effectiveEndTime = new Date(startTime.getTime() + (1000 * 60 * 60 * 24)); // This sets the effective end time to one day after the start time for example purposes.
        Purchase newPurchase = new Purchase(
                "user123",
                "com.example.product1",
                startTime,
                true,
                9.99f,
                7.99f,
                "TXN12345",
                "OTN12345",
                1,
                false,
                effectiveEndTime
        );

        // Create a new Purchase record
        Purchase createdPurchase = manager.createPurchase(newPurchase);

        // Get a Purchase record by transaction ID
        String transactionId = "some_transaction_id";
        Purchase purchaseByTransactionId = manager.getPurchaseByTransactionId(transactionId);

        // Get all Purchases by user ID
        String userId = "some_user_id";
        List<Purchase> purchasesByUserId = manager.getPurchasesByUserId(userId);

        // Update a Purchase record
        Purchase updatedPurchase = manager.updatePurchase(newPurchase);

        // Delete a Purchase record
        boolean isPurchaseDeleted = manager.deletePurchase(transactionId);

        // Retrieve all Purchase records
        List<Purchase> allPurchases = manager.listAllPurchases();

        // Example usage of the InsightsManager for ReportService
        // Create a new Report instance
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + 86400000); // 1 day after start date
        Report newReport = new Report("Annual Report", "Description of annual report", "ANNUAL", startDate, endDate);

        // Create a new Report record
        Report createdReport = manager.createReport(newReport);

        // Get a Report record by title
        String title = "Annual Sales";
        Report reportByTitle = manager.getReportByTitle(title);

        // Get all Reports by type
        String reportType = "Sales";
        List<Report> reportsByType = manager.getReportsByType(reportType);

        // Update a Report record
        manager.updateReport(newReport);

        // Delete a Report record
        manager.deleteReport(title);

        // Retrieve all Report records
        List<Report> allReports = manager.listAllReports();
    }
}
