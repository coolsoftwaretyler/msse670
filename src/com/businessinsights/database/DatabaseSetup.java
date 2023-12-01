package com.businessinsights.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseSetup {

    public static final String DATABASE_URL = "jdbc:sqlite:///Users/tylerwilliams/IdeaProjects/MSSE670/src/com/businessinsights/database/database.db";

    public static void main(String[] args) {
        // Load the JDBC driver (necessary for JDBC 3)
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return; // Exit if the driver class is not found
        }

        createTable("CREATE TABLE IF NOT EXISTS purchases (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "rcOriginalAppUserId TEXT NOT NULL, " +
                "productIdentifier TEXT NOT NULL, " +
                "startTime DATETIME NOT NULL, " +
                "isTrialPeriod BOOLEAN, " +
                "priceInUsd REAL, " +
                "purchasePriceInUsd REAL, " +
                "storeTransactionId TEXT NOT NULL, " +
                "originalStoreTransactionId TEXT, " +
                "renewalNumber INTEGER, " +
                "isTrialConversion BOOLEAN, " +
                "effectiveEndTime DATETIME NOT NULL" +
                ")");

        createTable("CREATE TABLE IF NOT EXISTS dailyadspends (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date DATETIME NOT NULL, " +
                "amountSpent REAL NOT NULL, " +
                "platform TEXT NOT NULL" +
                ")");

        createTable("CREATE TABLE IF NOT EXISTS reports (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT NOT NULL, " +
                "description TEXT NOT NULL, " +
                "reportType TEXT NOT NULL, " +
                "startDate DATETIME NOT NULL, " +
                "endDate DATETIME NOT NULL" +
                ")");
    }

    private static void createTable(String createTableSQL) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully with SQL: " + createTableSQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}