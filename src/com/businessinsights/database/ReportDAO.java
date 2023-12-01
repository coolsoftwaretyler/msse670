package com.businessinsights.database;

import com.businessinsights.model.domain.Report;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ReportDAO {

    private static final String INSERT_REPORT_SQL = "INSERT INTO reports " +
            "(title, description, reportType, startDate, endDate) " +
            "VALUES (?, ?, ?, ?, ?)";

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void saveReport(Report report) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DatabaseSetup.DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REPORT_SQL)) {
            preparedStatement.setString(1, report.getTitle());
            preparedStatement.setString(2, report.getDescription());
            preparedStatement.setString(3, report.getReportType());
            preparedStatement.setString(4, dateFormat.format(report.getStartDate()));
            preparedStatement.setString(5, dateFormat.format(report.getEndDate()));

            preparedStatement.executeUpdate();
        }
    }
}