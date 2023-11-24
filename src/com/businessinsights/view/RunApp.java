package com.businessinsights.view;

import com.businessinsights.model.business.manager.*;
import com.businessinsights.model.domain.*;

import java.util.Date;

public class RunApp {
    public static void main(String[] args) {
        String message = "";
        boolean reportGenerated = false;

        // InsightsManager needs to work this way
        InsightsManager manager = InsightsManager.getInstance();

        // First, we create two days of sample ad spend, and one sample purchase, and then we
        // run a report on that data.

        // Create two daily ad spend objects
        DailyAdSpend dailySpend1 = new DailyAdSpend();
        dailySpend1.setAmountSpent(100.00F);
        dailySpend1.setDate(new Date());
        dailySpend1.setPlatform("Facebook");
        DailyAdSpend dailySpend2 = new DailyAdSpend();
        dailySpend2.setAmountSpent(50.00F);
        dailySpend2.setDate(new Date());
        dailySpend2.setPlatform("Facebook");
        // Create one purchase for day 2 of the ad spend
        Date startTime = new Date();
        Date effectiveEndTime = new Date(startTime.getTime() + (1000 * 60 * 60 * 24)); // This sets the effective end time to one day after the start time for example purposes.
        Purchase purchase1 = new Purchase(
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

        // Create a composite class to hold the daily ad spends and Purchase
        Composite composite = new Composite();

        // Put the DailyAdSpends in an array to pass to the composite
        DailyAdSpend[] dailyAdSpendArray = new DailyAdSpend[]{dailySpend1, dailySpend2};

        // Put the purchase in an array to pass to the composite
        Purchase[] purchaseArray = new Purchase[]{purchase1};

        // Pass the inputs to the composite class to hold
        composite.setDailyAdSpends(dailyAdSpendArray);
        composite.setPurchases(purchaseArray);

        // Generate the report and log it to stdout
        reportGenerated = manager.performAction("GENERATE_REPORT", composite);

        if (reportGenerated) {
            message = "SUCCESS: Report Generated.";
        } else {
            message = "FAIL: Report not Generated.";
        }
        System.out.println(message);

        // Now create one more day of ad spend and two more purchases, and generate a second report
        DailyAdSpend dailySpend3 = new DailyAdSpend();
        dailySpend3.setPlatform("Facebook");
        dailySpend3.setDate(new Date());
        dailySpend3.setAmountSpent(200.0F);
        Date startTime2 = new Date();
        Date effectiveEndTime2 = new Date(startTime.getTime() + (1000 * 60 * 60 * 24)); // This sets the effective end time to one day after the start time for example purposes.
        Purchase purchase2 = new Purchase(
                "user123",
                "com.example.product1",
                startTime2,
                true,
                9.99f,
                7.99f,
                "TXN12345",
                "OTN12345",
                1,
                false,
                effectiveEndTime2
        );
        Date startTime3 = new Date();
        Date effectiveEndTime3 = new Date(startTime.getTime() + (1000 * 60 * 60 * 24)); // This sets the effective end time to one day after the start time for example purposes.
        Purchase purchase3 = new Purchase(
                "user123",
                "com.example.product1",
                startTime3,
                true,
                9.99f,
                7.99f,
                "TXN12345",
                "OTN12345",
                1,
                false,
                effectiveEndTime3
        );

        // Put the DailyAdSpends in an array to pass to the composite
        DailyAdSpend[] dailyAdSpendArray2 = new DailyAdSpend[]{dailySpend1, dailySpend2, dailySpend3};

        // Put the purchase in an array to pass to the composite
        Purchase[] purchaseArray2 = new Purchase[]{purchase1, purchase2, purchase3};

        // Pass the inputs to the composite class to hold
        composite.setDailyAdSpends(dailyAdSpendArray2);
        composite.setPurchases(purchaseArray2);

        reportGenerated = manager.performAction("GENERATE_REPORT", composite);

        if (reportGenerated) {
            message = "SUCCESS: Report Generated.";
        } else {
            message = "FAIL: Report not Generated.";
        }
        System.out.println(message);

        // List all available reports
        System.out.println();
        manager.performAction("LIST_REPORTS", composite);
        Report[] reportList = composite.getReports();

        for (Report r : reportList) {
            System.out.println("Report title: " + r.getTitle());
            System.out.println("Report type: " + r.getReportType());
            System.out.println("Report description: " + r.getDescription());
            System.out.println("Report start date: " + r.getStartDate());
            System.out.println("Report end date: " + r.getEndDate());

        }

    }
}
