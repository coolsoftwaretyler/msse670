package com.businessinsights.ui.mainjframe;

import com.businessinsights.model.domain.DailyAdSpend;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class MainJFrame extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();

        this.setSize(350, 300);
        this.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar = new javax.swing.JMenuBar();
        setJMenuBar(jMenuBar);
        jFileMenu = new javax.swing.JMenu();
        jDataMenu = new javax.swing.JMenu();
        jFileMenuItem = new javax.swing.JMenuItem();
        jDatabaseMenuItem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabelDate = new javax.swing.JLabel();
        jTextFieldDate = new javax.swing.JTextField();
        jLabelAmountSpent = new javax.swing.JLabel();
        jTextFieldAmountSpent = new javax.swing.JTextField();
        jLabelPlatform = new javax.swing.JLabel();
        jTextFieldPlatform = new javax.swing.JTextField();
        jButtonSubmit = new javax.swing.JButton();

        jMenuBar.setNextFocusableComponent(jFileMenu);
        jMenuBar.setOpaque(false);

        jFileMenu.setText("File");
        jFileMenu.setFont(new java.awt.Font("Comic Sans MS", 1, 11));

        jDataMenu.setText("Data");
        jDataMenu.setFont(new java.awt.Font("Comic Sans MS", 1, 11));

        jFileMenuItem.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
        jFileMenuItem.setText("Open From File...");
        jDataMenu.add(jFileMenuItem);

        jDatabaseMenuItem.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
        jDatabaseMenuItem.setText("Open from database...");
        jDatabaseMenuItem.setActionCommand("Open from Database...");
        jDataMenu.add(jDatabaseMenuItem);

        jFileMenu.add(jDataMenu);

        jMenuBar.add(jFileMenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Business Insights");
        setFont(new java.awt.Font("Comic Sans MS", 0, 10));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        jPanel1.setLayout(null);

        jLabelDate.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
        jLabelDate.setText("Date:");
        jPanel1.add(jLabelDate);
        jLabelDate.setBounds(47, 10, 70, 17);

        jTextFieldDate.setFont(new java.awt.Font("Comic Sans MS", 0, 11));
        jTextFieldDate.setText("yyyy-MM-dd");
        jPanel1.add(jTextFieldDate);
        jTextFieldDate.setBounds(130, 10, 90, 22);

        jLabelAmountSpent.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
        jLabelAmountSpent.setText("Amount Spent:");
        jPanel1.add(jLabelAmountSpent);
        jLabelAmountSpent.setBounds(17, 30, 100, 17);

        jTextFieldAmountSpent.setFont(new java.awt.Font("Comic Sans MS", 0, 11));
        jTextFieldAmountSpent.setText("0.00");
        jPanel1.add(jTextFieldAmountSpent);
        jTextFieldAmountSpent.setBounds(130, 30, 90, 22);

        jLabelPlatform.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
        jLabelPlatform.setText("Platform:");
        jPanel1.add(jLabelPlatform);
        jLabelPlatform.setBounds(17, 60, 100, 17);

        jTextFieldPlatform.setFont(new java.awt.Font("Comic Sans MS", 0, 11));
        jTextFieldPlatform.setText("Facebook");
        jPanel1.add(jTextFieldPlatform);
        jTextFieldPlatform.setBounds(130, 60, 90, 22);

        jButtonSubmit.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jButtonSubmit.setLabel("Submit");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSubmit);
        jButtonSubmit.setBounds(20, 200, 150, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 450, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    /**
     * Returns jFileMenuItem
     */
    public javax.swing.JMenuItem getFileMenuItem() {
        return jFileMenuItem;
    }

    /**
     * Returns jDatabaseMenuItem
     */
    public javax.swing.JMenuItem getDatabaseMenuItem() {
        return jDatabaseMenuItem;
    }

    /**
     * Returns jButtonSubmit
     */
    public javax.swing.JButton getSubmitButton() {
        return jButtonSubmit;
    }

    /**
     * Returns a DailyAdSpend domain object populated with user entered
     * data.
     */
    public DailyAdSpend getSelectedData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(jTextFieldDate.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Float amountSpent = Float.parseFloat(jTextFieldAmountSpent.getText());
        String platform = jTextFieldPlatform.getText();

        DailyAdSpend dailyAdSpend = new DailyAdSpend(date, amountSpent, platform);
        return dailyAdSpend;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JMenu jDataMenu;
    private javax.swing.JMenuItem jDatabaseMenuItem;
    private javax.swing.JMenu jFileMenu;
    private javax.swing.JMenuItem jFileMenuItem;
    private javax.swing.JLabel jLabelAmountSpent;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelPlatform;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldAmountSpent;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldPlatform;
}
// End of variables declaration//GEN-END:variables
