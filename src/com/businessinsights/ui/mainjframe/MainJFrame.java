package com.businessinsights.ui.mainjframe;

import com.businessinsights.ui.DailyAdSpendPanel;
import com.businessinsights.ui.PurchasePanel;

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
        JPanel reportPanel = new JPanel();

        jTabbedPane.addTab("Daily Ad Spend", new DailyAdSpendPanel());
        jTabbedPane.addTab("Purchase", new PurchasePanel());
        jTabbedPane.addTab("Report", reportPanel);

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