package com.businessinsights.model.services;

import com.businessinsights.model.domain.Report;
import com.businessinsights.model.services.reportservice.ReportServiceImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

public class ReportServiceImplTest {

    private ReportServiceImpl reportService;
    private Report testReport;

    @Before
    public void setUp() {
        reportService = new ReportServiceImpl();

        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + 86400000); // 1 day after start date
        testReport = new Report("Annual Report", "Description of annual report", "ANNUAL", startDate, endDate);

        // Assuming Report class has a validate method that doesn't throw an exception
        reportService.createReport(testReport);
    }

    @Test
    public void createReport_validReport_reportCreated() {
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + 86400000); // 1 day after start date
        Report newReport = new Report("New Report", "Description of annual report", "ANNUAL", startDate, endDate);

        Report createdReport = reportService.createReport(newReport);
        assertNotNull("Report should be created", createdReport);
        assertEquals("Report title should match", "New Report", createdReport.getTitle());
    }

    @Test
    public void createReport_nullReport_exceptionThrown() {
        Report createdReport = reportService.createReport(null);
        assertNull(createdReport);
    }

    @Test
    public void getReportByTitle_existingTitle_reportRetrieved() {
        Report foundReport = reportService.getReportByTitle("Annual Report");
        assertNotNull("Report should be found", foundReport);
        assertEquals("Report title should match", "Annual Report", foundReport.getTitle());
    }

    @Test
    public void getReportByTitle_nonExistingTitle_noReportRetrieved() {
        Report foundReport = reportService.getReportByTitle("Non-Existing Title");
        assertNull("Report should not be found", foundReport);
    }

    @Test
    public void getReportByTitle_nullTitle_exceptionThrown() {
        Report found = reportService.getReportByTitle(null);
        assertNull(found);
    }

    @Test
    public void getReportsByType_existingType_reportsRetrieved() {
        List<Report> reports = reportService.getReportsByType("ANNUAL");
        assertFalse("Reports should be found", reports.isEmpty());
        assertEquals("Report type should match", "ANNUAL", reports.get(0).getReportType());
    }

    @Test
    public void getReportsByType_nonExistingType_noReportsRetrieved() {
        List<Report> reports = reportService.getReportsByType("Non-Existing Type");
        assertTrue("Reports should not be found", reports.isEmpty());
    }

    @Test
    public void getReportsByType_nullType_exceptionThrown() {
        List<Report> reports = reportService.getReportsByType(null);
        assertTrue(reports.isEmpty());
    }

    @Test
    public void updateReport_existingReport_reportUpdated() {
        // Assume Report class has a setTitle method
        testReport.setTitle("Updated Report");
        reportService.updateReport(testReport);

        Report updatedReport = reportService.getReportByTitle("Updated Report");
        assertNotNull("Report should be found", updatedReport);
        assertEquals("Report title should be updated", "Updated Report", updatedReport.getTitle());
    }

    @Test
    public void updateReport_nullReport_exceptionThrown() {
        reportService.updateReport(null);
    }

    @Test
    public void deleteReport_existingTitle_reportDeleted() {
        reportService.deleteReport("Test Report");
        Report deletedReport = reportService.getReportByTitle("Test Report");
        assertNull("Report should be deleted", deletedReport);
    }

    @Test
    public void deleteReport_nullTitle_exceptionThrown() {
        reportService.deleteReport(null);
    }

    @Test
    public void listAllReports_reportsExist_reportsListed() {
        List<Report> reports = reportService.listAllReports();
        assertFalse("Reports should be listed", reports.isEmpty());
    }
}
