package com.businessinsights.ui.mainjframe;

import com.businessinsights.ui.DailyAdSpendPanel;

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
        JPanel purchasePanel = new JPanel();
        JPanel reportPanel = new JPanel();

        jTabbedPane.addTab("Daily Ad Spend", new DailyAdSpendPanel());
        jTabbedPane.addTab("Purchase", purchasePanel);
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