package com.businessinsights.view.panels;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {
    private JButton generateReportButton;
    private JTextArea reportArea;

    public ReportPanel() {
        setLayout(new BorderLayout());

        generateReportButton = new JButton("Generate Report");
        reportArea = new JTextArea();

        // Make the JTextArea scrollable
        JScrollPane scrollPane = new JScrollPane(reportArea);

        generateReportButton.addActionListener(e -> {
            // TODO: Add code to generate the report and set the text of reportArea
            // For example: reportArea.setText(reportController.generateReport());
        });

        add(generateReportButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}