package com.businessinsights.database;

import com.businessinsights.model.domain.Purchase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class PurchaseDAO {

    private static final String INSERT_PURCHASE_SQL = "INSERT INTO purchases " +
            "(rcOriginalAppUserId, productIdentifier, startTime, isTrialPeriod, priceInUsd, purchasePriceInUsd, " +
            "storeTransactionId, originalStoreTransactionId, renewalNumber, isTrialConversion, effectiveEndTime) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void savePurchase(Purchase purchase) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DatabaseSetup.DATABASE_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PURCHASE_SQL)) {
            preparedStatement.setString(1, purchase.getRcOriginalAppUserId());
            preparedStatement.setString(2, purchase.getProductIdentifier());
            preparedStatement.setString(3, dateFormat.format(purchase.getStartTime()));
            preparedStatement.setBoolean(4, purchase.getIsTrialPeriod());
            preparedStatement.setFloat(5, purchase.getPriceInUsd());
            preparedStatement.setFloat(6, purchase.getPurchasePriceInUsd());
            preparedStatement.setString(7, purchase.getStoreTransactionId());
            preparedStatement.setString(8, purchase.getOriginalStoreTransactionId());
            preparedStatement.setInt(9, purchase.getRenewalNumber());
            preparedStatement.setBoolean(10, purchase.getIsTrialConversion());
            preparedStatement.setString(11, dateFormat.format(purchase.getEffectiveEndTime()));

            preparedStatement.executeUpdate();
        }
    }
}