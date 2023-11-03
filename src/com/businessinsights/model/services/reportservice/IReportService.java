package com.businessinsights.model.services.reportservice;

import com.businessinsights.model.domain.Report;

import java.util.List;

public interface IReportService {
    /**
     * Creates a new report.
     *
     * @param report The Report object to create.
     * @return the report created
     */
    Report createReport(Report report);

    /**
     * Retrieves a report by its title.
     *
     * @param title The title of the report.
     * @return The Report object.
     */
    Report getReportByTitle(String title);

    /**
     * Retrieves all reports of a specific type.
     *
     * @param reportType The type of the reports to retrieve.
     * @return A list of Report objects.
     */
    List<Report> getReportsByType(String reportType);

    /**
     * Updates an existing report.
     *
     * @param report The Report object to update.
     */
    void updateReport(Report report);

    /**
     * Deletes a report by its title.
     *
     * @param title The title of the report to delete.
     */
    void deleteReport(String title);

    /**
     * Lists all reports.
     *
     * @return A list of all Report objects.
     */
    List<Report> listAllReports();
}
