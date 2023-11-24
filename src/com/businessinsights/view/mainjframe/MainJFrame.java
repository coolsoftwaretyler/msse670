package com.businessinsights.view.mainjframe;

import com.businessinsights.view.panels.DailyAdSpendPanel;
import com.businessinsights.view.panels.PurchasePanel;
import com.businessinsights.view.panels.ReportPanel;
import javax.swing.*;

public class MainJFrame extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    private DailyAdSpendPanel dailyAdSpendPanel;
    private PurchasePanel purchasePanel;
    private ReportPanel reportPanel;

    public MainJFrame() {
        initComponents();

        this.setSize(350, 300);
        this.setVisible(true);
    }

    private void initComponents() {
        JTabbedPane jTabbedPane = new JTabbedPane();

        dailyAdSpendPanel = new DailyAdSpendPanel();
        purchasePanel = new PurchasePanel();
        reportPanel = new ReportPanel();

        jTabbedPane.addTab("Daily Ad Spend", dailyAdSpendPanel);
        jTabbedPane.addTab("Purchase", purchasePanel);
        jTabbedPane.addTab("Report", reportPanel);

        getContentPane().add(jTabbedPane);

        pack();
    }

    public JButton getDailyAdSpendSubmitButton() {
        return dailyAdSpendPanel.getSubmitButton();
    }

    public JButton getPurchaseSubmitButton() {
        return purchasePanel.getSubmitButton();
    }

    public JButton getReportGenerateButton() {
        return reportPanel.getGenerateReportButton();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
}