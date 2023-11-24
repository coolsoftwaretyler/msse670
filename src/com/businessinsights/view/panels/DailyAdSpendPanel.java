package com.businessinsights.view.panels;

import javax.swing.*;
import java.awt.*;

public class DailyAdSpendPanel extends JPanel {
    private final JButton submitButton;

    public DailyAdSpendPanel() {
        setLayout(new GridLayout(5, 2));

        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField();
        JLabel amountSpentLabel = new JLabel("Amount Spent:");
        JTextField amountSpentField = new JTextField();
        JLabel platformLabel = new JLabel("Platform:");
        JTextField platformField = new JTextField();
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
}