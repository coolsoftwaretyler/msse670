package com.businessinsights.view.panels;

import com.businessinsights.model.domain.Purchase;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PurchasePanel extends JPanel {
    private JLabel userIdLabel;
    private JTextField userIdField;
    private JLabel productIdentifierLabel;
    private JTextField productIdentifierField;
    private JLabel startTimeLabel;
    private JTextField startTimeField;
    private JLabel isTrialPeriodLabel;
    private JCheckBox isTrialPeriodCheckBox;
    private JLabel priceInUsdLabel;
    private JTextField priceInUsdField;
    private JLabel purchasePriceInUsdLabel;
    private JTextField purchasePriceInUsdField;
    private JLabel storeTransactionIdLabel;
    private JTextField storeTransactionIdField;
    private JLabel originalStoreTransactionIdLabel;
    private JTextField originalStoreTransactionIdField;
    private JLabel renewalNumberLabel;
    private JTextField renewalNumberField;
    private JLabel isTrialConversionLabel;
    private JCheckBox isTrialConversionCheckBox;
    private JLabel effectiveEndTimeLabel;
    private JTextField effectiveEndTimeField;
    private JButton submitButton;

    public PurchasePanel() {
        setLayout(new GridLayout(12, 2));

        userIdLabel = new JLabel("User ID:");
        userIdField = new JTextField();
        productIdentifierLabel = new JLabel("Product Identifier:");
        productIdentifierField = new JTextField();
        startTimeLabel = new JLabel("Start Time (dd-MM-yyyy):");
        startTimeField = new JTextField();
        isTrialPeriodLabel = new JLabel("Is Trial Period:");
        isTrialPeriodCheckBox = new JCheckBox();
        priceInUsdLabel = new JLabel("Price in USD:");
        priceInUsdField = new JTextField();
        purchasePriceInUsdLabel = new JLabel("Purchase Price in USD:");
        purchasePriceInUsdField = new JTextField();
        storeTransactionIdLabel = new JLabel("Store Transaction ID:");
        storeTransactionIdField = new JTextField();
        originalStoreTransactionIdLabel = new JLabel("Original Store Transaction ID:");
        originalStoreTransactionIdField = new JTextField();
        renewalNumberLabel = new JLabel("Renewal Number:");
        renewalNumberField = new JTextField();
        isTrialConversionLabel = new JLabel("Is Trial Conversion:");
        isTrialConversionCheckBox = new JCheckBox();
        effectiveEndTimeLabel = new JLabel("Effective End Time (dd-MM-yyyy):");
        effectiveEndTimeField = new JTextField();
        submitButton = new JButton("Submit");

        submitButton.addActionListener(e -> {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date startTime;
            Date effectiveEndTime;
            try {
                startTime = formatter.parse(startTimeField.getText());
                effectiveEndTime = formatter.parse(effectiveEndTimeField.getText());
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please use dd-MM-yyyy.");
                return;
            }

            Float priceInUsd;
            Float purchasePriceInUsd;
            try {
                priceInUsd = Float.parseFloat(priceInUsdField.getText());
                purchasePriceInUsd = Float.parseFloat(purchasePriceInUsdField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid number.");
                return;
            }

            Integer renewalNumber;
            try {
                renewalNumber = Integer.parseInt(renewalNumberField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid renewal number. Please enter a valid number.");
                return;
            }

            Purchase purchase = new Purchase(
                    userIdField.getText(),
                    productIdentifierField.getText(),
                    startTime,
                    isTrialPeriodCheckBox.isSelected(),
                    priceInUsd,
                    purchasePriceInUsd,
                    storeTransactionIdField.getText(),
                    originalStoreTransactionIdField.getText(),
                    renewalNumber,
                    isTrialConversionCheckBox.isSelected(),
                    effectiveEndTime
            );

            try {
                purchase.validate();
                // TODO: Add code to handle the purchase object, e.g. save it to a database
                JOptionPane.showMessageDialog(this, "Purchase submitted successfully.");
            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(userIdLabel);
        add(userIdField);
        add(productIdentifierLabel);
        add(productIdentifierField);
        add(startTimeLabel);
        add(startTimeField);
        add(isTrialPeriodLabel);
        add(isTrialPeriodCheckBox);
        add(priceInUsdLabel);
        add(priceInUsdField);
        add(purchasePriceInUsdLabel);
        add(purchasePriceInUsdField);
        add(storeTransactionIdLabel);
        add(storeTransactionIdField);
        add(originalStoreTransactionIdLabel);
        add(originalStoreTransactionIdField);
        add(renewalNumberLabel);
        add(renewalNumberField);
        add(isTrialConversionLabel);
        add(isTrialConversionCheckBox);
        add(effectiveEndTimeLabel);
        add(effectiveEndTimeField);
        add(new JLabel());  // Empty space
        add(submitButton);
    }
}