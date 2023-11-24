package com.businessinsights.view.mainjframe;

import com.businessinsights.view.panels.DailyAdSpendPanel;
import com.businessinsights.view.panels.PurchasePanel;
import com.businessinsights.view.panels.ReportPanel;

import javax.swing.*;

public class MainJFrame extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    public MainJFrame() {
        initComponents();

        this.setSize(350, 300);
        this.setVisible(true);
    }

    private void initComponents() {
        JTabbedPane jTabbedPane = new JTabbedPane();

        jTabbedPane.addTab("Daily Ad Spend", new DailyAdSpendPanel());
        jTabbedPane.addTab("Purchase", new PurchasePanel());
        jTabbedPane.addTab("Report", new ReportPanel());

        getContentPane().add(jTabbedPane);

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
}