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