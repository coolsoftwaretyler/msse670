package com.businessinsights.view.panels;

import com.businessinsights.model.domain.DailyAdSpend;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class DailyAdSpendPanel extends JPanel {
    private JLabel dateLabel;
    private JTextField dateField;
    private JLabel amountSpentLabel;
    private JTextField amountSpentField;
    private JLabel platformLabel;
    private JTextField platformField;
    private JButton submitButton;

    public DailyAdSpendPanel() {
        setLayout(new GridLayout(5, 2));

        dateLabel = new JLabel("Date:");
        dateField = new JTextField();
        amountSpentLabel = new JLabel("Amount Spent:");
        amountSpentField = new JTextField();
        platformLabel = new JLabel("Platform:");
        platformField = new JTextField();
        submitButton = new JButton("Submit");

        submitButton.addActionListener(e -> {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date;
            try {
                date = formatter.parse(dateField.getText());
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please use dd-MM-yyyy.");
                return;
            }

            Float amountSpent;
            try {
                amountSpent = Float.parseFloat(amountSpentField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount spent. Please enter a valid number.");
                return;
            }

            String platform = platformField.getText();
            if (platform.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Platform cannot be empty.");
                return;
            }

            DailyAdSpend dailyAdSpend = new DailyAdSpend(date, amountSpent, platform);

            try {
                dailyAdSpend.validate();
                // TODO: Add code to handle the dailyAdSpend object, e.g. save it to a database
                JOptionPane.showMessageDialog(this, "Daily Ad Spend submitted successfully.");
            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        add(dateLabel);
        add(dateField);
        add(amountSpentLabel);
        add(amountSpentField);
        add(platformLabel);
        add(platformField);
        add(new JLabel());  // Empty space
        add(submitButton);
    }
}