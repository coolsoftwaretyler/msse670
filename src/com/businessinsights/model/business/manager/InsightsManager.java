package com.businessinsights.model.business.manager;

import com.businessinsights.model.business.exception.ServiceLoadException;
import com.businessinsights.model.domain.Composite;
import com.businessinsights.model.domain.DailyAdSpend;
import com.businessinsights.model.domain.Purchase;
import com.businessinsights.model.domain.Report;
import com.businessinsights.model.services.dailyadspendservice.DailyAdSpendServiceImpl;
import com.businessinsights.model.services.dailyadspendservice.IDailyAdSpendService;
import com.businessinsights.model.services.factory.ServiceFactory;
import com.businessinsights.model.services.purchaseservice.PurchaseServiceImpl;
import com.businessinsights.model.services.purchaseservice.IPurchaseService;
import com.businessinsights.model.services.reportservice.ReportServiceImpl;
import com.businessinsights.model.services.reportservice.IReportService;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class InsightsManager extends ManagerSuperType {
    private static InsightsManager _instance;

    private final IDailyAdSpendService dailyAdSpendService;
    private final IPurchaseService purchaseService;
    private final IReportService reportService;

    /**
     * keep the constructor private to prevent instantiation by outside callers.
     */
    private InsightsManager() {
        this.dailyAdSpendService = new DailyAdSpendServiceImpl();
        this.purchaseService = new PurchaseServiceImpl();
        this.reportService = new ReportServiceImpl();
    }

    /**
     * Assures that there is only one FleetRentalManager created.
     *
     * @return FleetRentalManager instance
     */
    public static synchronized InsightsManager getInstance() {
        if (_instance == null) {
            _instance = new InsightsManager();
        }
        return _instance;
    }

    /**
     * Generic method that all clients of this class can call to perform certain
     * actions.
     *
     * @param commandString
     *            Holds the service name to be invoked *
     * @param composite
     *            Holds application specific domain state
     * @return false if action failed true if action is successful
     */
    @Override
    public boolean performAction(String commandString,
                                 Composite composite) {
        boolean ret = false;
        if (commandString.equals("GENERATE_REPORT")) {
            generateReport(IReportService.NAME, composite);
            ret = true;
        } else if (commandString.equals("LIST_REPORTS")) {
            getReportList(IReportService.NAME, composite);
            ret = true;
        } else {
            System.out.println("INFO:  Add new workflows here using here using if/else.");
        }
        return ret;
    }

    public boolean generateReport(String commandString, Composite composite) {
        boolean result = false;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IReportService reportService;

        try {
            reportService = (IReportService) serviceFactory.getService(commandString);
            result = reportService.generateReport(composite);
        } catch (ServiceLoadException e) {
            System.out.println("InsightsManager::generateReport failed"); // defaulting
        }
        return result;
    }


    public boolean getReportList(String commandString, Composite composite) {
        boolean result = false;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IReportService reportService;

        try {
            reportService = (IReportService) serviceFactory.getService(commandString);
            result = reportService.getReports(composite);
        } catch (ServiceLoadException e) {
            System.out.println(e);
            System.out.println("InsightsManager::getReportList failed"); // defaulting
        }

        return result;
    }



    // Main method to demonstrate usage
//    public static void main(String[] args) {
//        InsightsManager manager = new InsightsManager();
//
//        // Example usage of the InsightsManager
//        // Create a new DailyAdSpend instance (assuming DailyAdSpend has an appropriate constructor)
//        DailyAdSpend newSpend = new DailyAdSpend();
//
//        // Create a new DailyAdSpend record
//        DailyAdSpend createdSpend = manager.createDailyAdSpend(newSpend);
//
//        // Get a DailyAdSpend record by date
//        Date date = new Date();
//        DailyAdSpend spendByDate = manager.getDailyAdSpendByDate(date);
//
//        // Update a DailyAdSpend record
//        DailyAdSpend updatedSpend = manager.updateDailyAdSpend(newSpend);
//
//        // Delete a DailyAdSpend record
//        boolean isDeleted = manager.deleteDailyAdSpend(date);
//
//        // Retrieve all DailyAdSpend records
//        List<DailyAdSpend> allSpends = manager.getAllDailyAdSpends();
//
//        // Example usage of the InsightsManager for PurchaseService
//        // Create a new Purchase instance
//        Date startTime = new Date();
//        Date effectiveEndTime = new Date(startTime.getTime() + (1000 * 60 * 60 * 24)); // This sets the effective end time to one day after the start time for example purposes.
//        Purchase newPurchase = new Purchase(
//                "user123",
//                "com.example.product1",
//                startTime,
//                true,
//                9.99f,
//                7.99f,
//                "TXN12345",
//                "OTN12345",
//                1,
//                false,
//                effectiveEndTime
//        );
//
//        // Create a new Purchase record
//        Purchase createdPurchase = manager.createPurchase(newPurchase);
//
//        // Get a Purchase record by transaction ID
//        String transactionId = "some_transaction_id";
//        Purchase purchaseByTransactionId = manager.getPurchaseByTransactionId(transactionId);
//
//        // Get all Purchases by user ID
//        String userId = "some_user_id";
//        List<Purchase> purchasesByUserId = manager.getPurchasesByUserId(userId);
//
//        // Update a Purchase record
//        Purchase updatedPurchase = manager.updatePurchase(newPurchase);
//
//        // Delete a Purchase record
//        boolean isPurchaseDeleted = manager.deletePurchase(transactionId);
//
//        // Retrieve all Purchase records
//        List<Purchase> allPurchases = manager.listAllPurchases();
//
//        // Example usage of the InsightsManager for ReportService
//        // Create a new Report instance
//        Date startDate = new Date();
//        Date endDate = new Date(startDate.getTime() + 86400000); // 1 day after start date
//        Report newReport = new Report("Annual Report", "Description of annual report", "ANNUAL", startDate, endDate);
//
//        // Create a new Report record
//        Report createdReport = manager.createReport(newReport);
//
//        // Get a Report record by title
//        String title = "Annual Sales";
//        Report reportByTitle = manager.getReportByTitle(title);
//
//        // Get all Reports by type
//        String reportType = "Sales";
//        List<Report> reportsByType = manager.getReportsByType(reportType);
//
//        // Update a Report record
//        manager.updateReport(newReport);
//
//        // Delete a Report record
//        manager.deleteReport(title);
//
//        // Retrieve all Report records
//        List<Report> allReports = manager.listAllReports();
//    }
}
