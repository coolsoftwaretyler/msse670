package com.businessinsights.view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.businessinsights.model.business.manager.InsightsManager;
import com.businessinsights.model.domain.Composite;
import com.businessinsights.model.domain.DailyAdSpend;
import com.businessinsights.model.domain.Purchase;
import com.businessinsights.view.MessageDialog;
import com.businessinsights.view.Utils;
import com.businessinsights.view.panels.DailyAdSpendPanel;
import com.businessinsights.view.panels.PurchasePanel;
import com.businessinsights.view.panels.ReportPanel;

import javax.swing.*;

public class MainJFrameController implements ActionListener {

    private final MainJFrame mainJFrame;

    private final Composite composite = new Composite();

    private InsightsManager insightsManager = new InsightsManager();

    public MainJFrameController(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;

        mainJFrame.getDailyAdSpendSubmitButton().addActionListener(this);
        mainJFrame.getPurchaseSubmitButton().addActionListener(this);
        mainJFrame.getReportGenerateButton().addActionListener(this);

        Utils.centerWindow(mainJFrame);
        mainJFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println ("Inside MainJFrameController::actionPerformed");

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

        Float amountFloat = parseToFloat(amountField.getText());
        Date parsedDate = parseToDate(dateField.getText());

        if (amountFloat == null || parsedDate == null) {
            showErrorDialog("Submit", "Invalid input");
            return;
        }

        DailyAdSpend dailyAdSpend = new DailyAdSpend();
        dailyAdSpend.setAmountSpent(amountFloat);
        dailyAdSpend.setDate(parsedDate);
        dailyAdSpend.setPlatform(platformField.getText());

        DailyAdSpend[] dailyAdSpendArray = new DailyAdSpend[]{dailyAdSpend};

        composite.setDailyAdSpends(dailyAdSpendArray);

        // Resetting input fields after creating daily ad spend
        dateField.setText(""); // Reset date field
        amountField.setText(""); // Reset amount field
        platformField.setText(""); // Reset platform field

        showMessageDialog("Submit", "Daily Ad Spend Created");
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

        Date startTime = parseToDate(startTimeField.getText());
        Date effectiveEndTime = parseToDate(effectiveEndTimeField.getText());
        Float priceInUsd = parseToFloat(priceInUsdField.getText());
        Float purchasePriceInUsd = parseToFloat(purchasePriceInUsdField.getText());
        Integer renewalNumber = parseToInteger(renewalNumberField.getText());

        if (startTime == null || effectiveEndTime == null || priceInUsd == null || purchasePriceInUsd == null || renewalNumber == null) {
            showErrorDialog("Submit", "Invalid input");
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

        Purchase[] purchaseArray = new Purchase[]{purchase};

        composite.setPurchases(purchaseArray);


        // Resetting input fields after creating a purchase
        userIdField.setText(""); // Reset userId field
        productIdentifierField.setText(""); // Reset product identifier field
        startTimeField.setText(""); // Reset startTime field

        isTrialPeriodCheckBox.setSelected(false); // Reset checkbox
        priceInUsdField.setText(""); // Reset priceInUsd field
        purchasePriceInUsdField.setText(""); // Reset purchasePriceInUsd field
        storeTransactionIdField.setText(""); // Reset storeTransactionId field
        originalStoreTransactionIdField.setText(""); // Reset originalStoreTransactionId field
        renewalNumberField.setText(""); // Reset renewalNumber field
        isTrialConversionCheckBox.setSelected(false); // Reset checkbox
        effectiveEndTimeField.setText(""); // Reset effectiveEndTime field
        showMessageDialog("Submit", "Purchase Created");
    }

    void reportGenerateButton_actionPerformed(ActionEvent actionEvent) {
        System.out.println("Inside MainJFrameController");

        // Generate report
        insightsManager.performAction("GENERATE_REPORT", composite);

        // Write reports to the JTextArea in ReportPanel
        String reports = Arrays.toString(composite.getReports());
        ReportPanel reportPanel = mainJFrame.getReportPanel();
        JTextArea reportArea = reportPanel.getReportArea();
        reportArea.setText(reports);

        showMessageDialog("Generate", "Report Generated and Listed!");
    }

    private Float parseToFloat(String value) {
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Date parseToDate(String value) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    private Integer parseToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void showMessageDialog(String title, String message) {
        MessageDialog dlg = new MessageDialog(title, message);
        Utils.centerWindow(dlg);
        dlg.setModal(true);
        dlg.show();
    }

    private void showErrorDialog(String title, String message) {
        JOptionPane.showMessageDialog(mainJFrame, message, title, JOptionPane.ERROR_MESSAGE);
    }
}