package com.businessinsights.view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.businessinsights.model.domain.Composite;
import com.businessinsights.model.domain.DailyAdSpend;
import com.businessinsights.model.domain.Purchase;
import com.businessinsights.view.MessageDialog;
import com.businessinsights.view.Utils;
import com.businessinsights.view.panels.DailyAdSpendPanel;
import com.businessinsights.view.panels.PurchasePanel;

import javax.swing.*;

public class MainJFrameController implements ActionListener {

    private MainJFrame mainJFrame;

    private Composite composite = new Composite();


    public MainJFrameController(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;

        // Add action listeners for the components in each tab
        mainJFrame.getDailyAdSpendSubmitButton().addActionListener(this);
        mainJFrame.getPurchaseSubmitButton().addActionListener(this);
        mainJFrame.getReportGenerateButton().addActionListener(this);

        Utils.centerWindow(mainJFrame);
        mainJFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println ("Inside MainJFrameController::actionPerformed");

        // Handle actions for the components in each tab
        if (event.getSource().equals(mainJFrame.getDailyAdSpendSubmitButton()))
            dailyAdSpendSubmitButton_actionPerformed(event);
        else if (event.getSource().equals(mainJFrame.getPurchaseSubmitButton()))
            purchaseSubmitButton_actionPerformed(event);
        else if (event.getSource().equals(mainJFrame.getReportGenerateButton()))
            reportGenerateButton_actionPerformed(event);
    }

    void dailyAdSpendSubmitButton_actionPerformed(ActionEvent actionEvent) {
        System.out.println("Inside MainJFrameController");
        DailyAdSpendPanel dailyAdSpendPanel = mainJFrame.getDailyAdSpendPanel();
        JTextField dateField = dailyAdSpendPanel.getDateField();
        JTextField amountField = dailyAdSpendPanel.getAmountSpentField();
        JTextField platformField = dailyAdSpendPanel.getPlatformField();

        Float amountFloat = null;
        Date date = null;
        try {
            amountFloat = Float.parseFloat(amountField.getText());
            // Now amountFloat contains the float value parsed from the text
        } catch (NumberFormatException e) {
            // Handle the case where the text is not a valid float
            e.printStackTrace(); // or handle the exception in a way that fits your application
        }

        String dateString = dateField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(dateString);
            // Now parsedDate contains the parsed date object
        } catch (ParseException e) {
            // Handle parsing exception if the date string format is incorrect
            e.printStackTrace(); // or handle the exception in a way that fits your application
        }

        DailyAdSpend dailyAdSpend = new DailyAdSpend();
        dailyAdSpend.setAmountSpent(amountFloat);
        dailyAdSpend.setDate(parsedDate);
        dailyAdSpend.setPlatform(platformField.getText());

        DailyAdSpend[] dailyAdSpendArray = new DailyAdSpend[]{dailyAdSpend};

        // Pass the inputs to the composite class to hold
        composite.setDailyAdSpends(dailyAdSpendArray);

        MessageDialog dlg = new MessageDialog("Submit", "Daily Ad Spend Created");
        Utils.centerWindow(dlg);
        dlg.setModal(true);
        dlg.show();
    }

    void purchaseSubmitButton_actionPerformed(ActionEvent actionEvent) {
            System.out.println("Inside MainJFrameController");
            PurchasePanel purchasePanel = mainJFrame.getPurchasePanel();
            JTextField userIdField = purchasePanel.getUserIdField();
            JTextField productIdentifierField = purchasePanel.getProductIdentifierField();
            JTextField startTimeField = purchasePanel.getStartTimeField();
            JCheckBox isTrialPeriodCheckBox = purchasePanel.getIsTrialPeriodCheckBox();
            JTextField priceInUsdField = purchasePanel.getPriceInUsdField();
            JTextField purchasePriceInUsdField = purchasePanel.getPurchasePriceInUsdField();
            JTextField storeTransactionIdField = purchasePanel.getStoreTransactionIdField();
            JTextField originalStoreTransactionIdField = purchasePanel.getOriginalStoreTransactionIdField();
            JTextField renewalNumberField = purchasePanel.getRenewalNumberField();
            JCheckBox isTrialConversionCheckBox = purchasePanel.getIsTrialConversionCheckBox();
            JTextField effectiveEndTimeField = purchasePanel.getEffectiveEndTimeField();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date startTime = null;
            Date effectiveEndTime = null;
            try {
                startTime = dateFormat.parse(startTimeField.getText());
                effectiveEndTime = dateFormat.parse(effectiveEndTimeField.getText());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Float priceInUsd = null;
            Float purchasePriceInUsd = null;
            try {
                priceInUsd = Float.parseFloat(priceInUsdField.getText());
                purchasePriceInUsd = Float.parseFloat(purchasePriceInUsdField.getText());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            Integer renewalNumber = null;
            try {
                renewalNumber = Integer.parseInt(renewalNumberField.getText());
            } catch (NumberFormatException e) {
                e.printStackTrace();
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

            Purchase[] purchaseArray = new Purchase[]{purchase};

            composite.setPurchases(purchaseArray);

            MessageDialog dlg = new MessageDialog("Submit", "Purchase Created");
            Utils.centerWindow(dlg);
            dlg.setModal(true);
            dlg.show();
        }

    void reportGenerateButton_actionPerformed(ActionEvent actionEvent) {
        System.out.println("Inside MainJFrameController");
        MessageDialog dlg = new MessageDialog("Generate", "Not Implemented Yet!");
        Utils.centerWindow(dlg);
        dlg.setModal(true);
        dlg.show();
    }
}