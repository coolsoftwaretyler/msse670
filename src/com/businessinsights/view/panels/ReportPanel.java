package com.businessinsights.view.panels;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {
    private final JButton generateReportButton;
    private final JTextArea reportArea;

    public ReportPanel() {
        setLayout(new BorderLayout());

        generateReportButton = new JButton("Generate Report");
        reportArea = new JTextArea();

        // Make the JTextArea scrollable
        JScrollPane scrollPane = new JScrollPane(reportArea);

        add(generateReportButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public JButton getGenerateReportButton() {
        return generateReportButton;
    }

    public JTextArea getReportArea() {
        return reportArea;
    }
}