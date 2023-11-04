package com.businessinsights.model.services.factory;

import com.businessinsights.model.services.dailyadspendservice.DailyAdSpendServiceImpl;
import com.businessinsights.model.services.dailyadspendservice.IDailyAdSpendService;
import com.businessinsights.model.services.purchaseservice.IPurchaseService;
import com.businessinsights.model.services.purchaseservice.PurchaseServiceImpl;
import com.businessinsights.model.services.reportservice.IReportService;
import com.businessinsights.model.services.reportservice.ReportServiceImpl;

/**
 * Simplistic implementation of a Service Factory.
 */
public class ServiceFactory
{
    public IDailyAdSpendService getLoginService()
    {
        return new DailyAdSpendServiceImpl();
    }
    public IPurchaseService getPurchaseService() { return new PurchaseServiceImpl(); }
    public IReportService getReportService() { return new ReportServiceImpl(); }
}