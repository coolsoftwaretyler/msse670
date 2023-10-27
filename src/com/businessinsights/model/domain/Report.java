package com.businessinsights.model.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a report containing details of a particular business insight.
 */
public class Report {
    /** The title of the report. */
    private String title;

    /** A brief description of the report. */
    private String description;

    /** The type of the report. This should be converted to an enum in future. */
    private String reportType;

    /** The start date of the reporting period. */
    private Date startDate;

    /** The end date of the reporting period. */
    private Date endDate;

    /**
     * Retrieves the title of the report.
     *
     * @return the title of the report
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the report.
     *
     * @param title the title of the report
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the description of the report.
     *
     * @return the description of the report
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the report.
     *
     * @param description the description of the report
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the type of the report.
     *
     * @return the report type
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * Sets the type of the report.
     *
     * @param reportType the report type
     */
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    /**
     * Retrieves the start date of the reporting period.
     *
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the reporting period.
     *
     * @param startDate the start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Retrieves the end date of the reporting period.
     *
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the reporting period.
     *
     * @param endDate the end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Converts the report information to a string format.
     *
     * @return a string representation of the report
     */
    @Override
    public String toString() {
        return "Report{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", reportType='" + reportType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    /**
     * Compares this report object to another object.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(title, report.title) &&
                Objects.equals(description, report.description) &&
                Objects.equals(reportType, report.reportType) &&
                Objects.equals(startDate, report.startDate) &&
                Objects.equals(endDate, report.endDate);
    }

    /**
     * Generates a hash code for this report object.
     *
     * @return a hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, description, reportType, startDate, endDate);
    }

    /**
     * Validates the report object ensuring all required fields are set and valid.
     *
     * @throws IllegalStateException if any validation check fails
     */
    public void validate() throws IllegalStateException {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalStateException("Title cannot be null or empty");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalStateException("Description cannot be null or empty");
        }
        if (reportType == null || reportType.trim().isEmpty()) {
            throw new IllegalStateException("Report type cannot be null or empty");
        }
        if (startDate == null) {
            throw new IllegalStateException("Start date cannot be null");
        }
        if (endDate == null) {
            throw new IllegalStateException("End date cannot be null");
        }
        if (endDate.before(startDate)) {
            throw new IllegalStateException("End date cannot be before start date");
        }
    }
}
