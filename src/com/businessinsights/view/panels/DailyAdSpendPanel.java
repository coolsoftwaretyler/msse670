package com.businessinsights.view.panels;

import javax.swing.*;
import java.awt.*;

public class DailyAdSpendPanel extends JPanel {
    private final JButton submitButton;
    private final JLabel dateLabel;
    private final JTextField dateField;
    private final JLabel amountSpentLabel;
    private final JTextField amountSpentField;
    private final JLabel platformLabel;
    private final JTextField platformField;

    public DailyAdSpendPanel() {
        setLayout(new GridLayout(5, 2));

        dateLabel = new JLabel("Date:");
        dateField = new JTextField();
        amountSpentLabel = new JLabel("Amount Spent:");
        amountSpentField = new JTextField();
        platformLabel = new JLabel("Platform:");
        platformField = new JTextField();
        submitButton = new JButton("Submit");

        add(dateLabel);
        add(dateField);
        add(amountSpentLabel);
        add(amountSpentField);
        add(platformLabel);
        add(platformField);
        add(new JLabel());  // Empty space
        add(submitButton);
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JLabel getDateLabel() {
        return dateLabel;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public JLabel getAmountSpentLabel() {
        return amountSpentLabel;
    }

    public JTextField getAmountSpentField() {
        return amountSpentField;
    }

    public JLabel getPlatformLabel() {
        return platformLabel;
    }

    public JTextField getPlatformField() {
        return platformField;
    }
}