package com.businessinsights.view.panels;

import javax.swing.*;
import java.awt.*;

public class PurchasePanel extends JPanel {
    private final JButton submitButton;

    public PurchasePanel() {
        setLayout(new GridLayout(12, 2));

        JLabel userIdLabel = new JLabel("User ID:");
        JTextField userIdField = new JTextField();
        JLabel productIdentifierLabel = new JLabel("Product Identifier:");
        JTextField productIdentifierField = new JTextField();
        JLabel startTimeLabel = new JLabel("Start Time (dd-MM-yyyy):");
        JTextField startTimeField = new JTextField();
        JLabel isTrialPeriodLabel = new JLabel("Is Trial Period:");
        JCheckBox isTrialPeriodCheckBox = new JCheckBox();
        JLabel priceInUsdLabel = new JLabel("Price in USD:");
        JTextField priceInUsdField = new JTextField();
        JLabel purchasePriceInUsdLabel = new JLabel("Purchase Price in USD:");
        JTextField purchasePriceInUsdField = new JTextField();
        JLabel storeTransactionIdLabel = new JLabel("Store Transaction ID:");
        JTextField storeTransactionIdField = new JTextField();
        JLabel originalStoreTransactionIdLabel = new JLabel("Original Store Transaction ID:");
        JTextField originalStoreTransactionIdField = new JTextField();
        JLabel renewalNumberLabel = new JLabel("Renewal Number:");
        JTextField renewalNumberField = new JTextField();
        JLabel isTrialConversionLabel = new JLabel("Is Trial Conversion:");
        JCheckBox isTrialConversionCheckBox = new JCheckBox();
        JLabel effectiveEndTimeLabel = new JLabel("Effective End Time (dd-MM-yyyy):");
        JTextField effectiveEndTimeField = new JTextField();
        submitButton = new JButton("Submit");

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

    public JButton getSubmitButton() {
        return submitButton;
    }

}