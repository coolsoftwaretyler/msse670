package com.businessinsights.view.panels;

import javax.swing.*;
import java.awt.*;

public class PurchasePanel extends JPanel {
    private final JButton submitButton;
    private final JTextField userIdField;
    private final JTextField productIdentifierField;
    private final JTextField startTimeField;
    private final JCheckBox isTrialPeriodCheckBox;
    private final JTextField priceInUsdField;
    private final JTextField purchasePriceInUsdField;
    private final JTextField storeTransactionIdField;
    private final JTextField originalStoreTransactionIdField;
    private final JTextField renewalNumberField;
    private final JCheckBox isTrialConversionCheckBox;
    private final JTextField effectiveEndTimeField;

    public PurchasePanel() {
        setLayout(new GridLayout(12, 2));

        JLabel userIdLabel = new JLabel("User ID:");
        userIdField = new JTextField();
        JLabel productIdentifierLabel = new JLabel("Product Identifier:");
        productIdentifierField = new JTextField();
        JLabel startTimeLabel = new JLabel("Start Time (dd-MM-yyyy):");
        startTimeField = new JTextField();
        JLabel isTrialPeriodLabel = new JLabel("Is Trial Period:");
        isTrialPeriodCheckBox = new JCheckBox();
        JLabel priceInUsdLabel = new JLabel("Price in USD:");
        priceInUsdField = new JTextField();
        JLabel purchasePriceInUsdLabel = new JLabel("Purchase Price in USD:");
        purchasePriceInUsdField = new JTextField();
        JLabel storeTransactionIdLabel = new JLabel("Store Transaction ID:");
        storeTransactionIdField = new JTextField();
        JLabel originalStoreTransactionIdLabel = new JLabel("Original Store Transaction ID:");
        originalStoreTransactionIdField = new JTextField();
        JLabel renewalNumberLabel = new JLabel("Renewal Number:");
        renewalNumberField = new JTextField();
        JLabel isTrialConversionLabel = new JLabel("Is Trial Conversion:");
        isTrialConversionCheckBox = new JCheckBox();
        JLabel effectiveEndTimeLabel = new JLabel("Effective End Time (dd-MM-yyyy):");
        effectiveEndTimeField = new JTextField();
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

    public JTextField getUserIdField() {
        return userIdField;
    }

    public JTextField getProductIdentifierField() {
        return productIdentifierField;
    }

    public JTextField getStartTimeField() {
        return startTimeField;
    }

    public JCheckBox getIsTrialPeriodCheckBox() {
        return isTrialPeriodCheckBox;
    }

    public JTextField getPriceInUsdField() {
        return priceInUsdField;
    }

    public JTextField getPurchasePriceInUsdField() {
        return purchasePriceInUsdField;
    }

    public JTextField getStoreTransactionIdField() {
        return storeTransactionIdField;
    }

    public JTextField getOriginalStoreTransactionIdField() {
        return originalStoreTransactionIdField;
    }

    public JTextField getRenewalNumberField() {
        return renewalNumberField;
    }

    public JCheckBox getIsTrialConversionCheckBox() {
        return isTrialConversionCheckBox;
    }

    public JTextField getEffectiveEndTimeField() {
        return effectiveEndTimeField;
    }
}