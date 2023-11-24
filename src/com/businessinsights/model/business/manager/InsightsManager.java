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
    public InsightsManager() {
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

    private boolean generateReport(String commandString, Composite composite) {
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


    private boolean getReportList(String commandString, Composite composite) {
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
}
