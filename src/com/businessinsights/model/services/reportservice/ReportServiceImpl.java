package com.businessinsights.model.services.reportservice;

import com.businessinsights.model.domain.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReportServiceImpl implements IReportService {

    private final List<Report> reports = new ArrayList<>(); // Temporary in-memory list

    @Override
    public Report createReport(Report report) {
            System.out.println("Creating a new Report record in the service");
            if (report == null) {
                throw new IllegalArgumentException("Report object cannot be null");
            }
            // Assume Report has a validate method
            report.validate(); // Ensure the Report is valid before adding
            reports.add(report);
            return report;
    }

    @Override
    public Report getReportByTitle(String title) {
        try {
            System.out.println("Retrieving a Report record by title from the service");
            if (title == null || title.isEmpty()) {
                throw new IllegalArgumentException("Title cannot be null or empty");
            }
            return reports.stream()
                    .filter(r -> title.equals(r.getTitle()))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("Failed to retrieve Report: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Report> getReportsByType(String reportType) {
        try {
            System.out.println("Retrieving Report records by type from the service");
            if (reportType == null || reportType.isEmpty()) {
                throw new IllegalArgumentException("Report type cannot be null or empty");
            }
            return reports.stream()
                    .filter(r -> reportType.equals(r.getReportType()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Failed to retrieve Reports by type: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void updateReport(Report report) {
        try {
            System.out.println("Updating an existing Report record in the service");
            if (report == null) {
                throw new IllegalArgumentException("Report object cannot be null");
            }
            report.validate();

            Optional<Report> existingReport = reports.stream()
                    .filter(r -> r.getTitle().equals(report.getTitle()))
                    .findFirst();

            if (existingReport.isPresent()) {
                Report toUpdate = existingReport.get();
                // Assuming Report has setters for updating its fields
                // Update the relevant fields of the Report here
                System.out.println("Report record updated for title: " + toUpdate.getTitle());
            } else {
                System.out.println("No Report record found for title: " + report.getTitle());
            }
        } catch (Exception e) {
            System.out.println("Failed to update Report: " + e.getMessage());
        }
    }

    @Override
    public void deleteReport(String title) {
        try {
            System.out.println("Deleting a Report record by title from the service");
            if (title == null || title.isEmpty()) {
                throw new IllegalArgumentException("Title cannot be null or empty");
            }
            boolean removed = reports.removeIf(r -> title.equals(r.getTitle()));
            if (removed) {
                System.out.println("Report deleted successfully for title: " + title);
            } else {
                System.out.println("No Report found to delete for title: " + title);
            }
        } catch (Exception e) {
            System.out.println("Failed to delete Report: " + e.getMessage());
        }
    }

    @Override
    public List<Report> listAllReports() {
        try {
            System.out.println("Retrieving all Report records from the service");
            return new ArrayList<>(reports);
        } catch (Exception e) {
            System.out.println("Failed to retrieve all Reports: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
