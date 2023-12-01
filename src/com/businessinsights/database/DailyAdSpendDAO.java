package com.businessinsights.database;

import com.businessinsights.model.domain.DailyAdSpend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class DailyAdSpendDAO {

    private static final String INSERT_DAILY_AD_SPEND_SQL = "INSERT INTO dailyadspends " +
            "(date, amountSpent, platform) " +
            "VALUES (?, ?, ?)";

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void saveDailyAdSpend(DailyAdSpend dailyAdSpend) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DatabaseSetup.DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DAILY_AD_SPEND_SQL)) {
            preparedStatement.setString(1, dateFormat.format(dailyAdSpend.getDate()));
            preparedStatement.setFloat(2, dailyAdSpend.getAmountSpent());
            preparedStatement.setString(3, dailyAdSpend.getPlatform());

            preparedStatement.executeUpdate();
        }
    }
}