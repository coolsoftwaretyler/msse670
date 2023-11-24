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