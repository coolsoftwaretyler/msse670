package com.businessinsights.view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.businessinsights.view.MessageDialog;
import com.businessinsights.view.Utils;

public class MainJFrameController implements ActionListener {

    private MainJFrame mainJFrame;

    public MainJFrameController(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;

        // Add action listeners for the components in each tab
        mainJFrame.getDailyAdSpendSubmitButton().addActionListener(this);
        mainJFrame.getPurchaseSubmitButton().addActionListener(this);
        mainJFrame.getReportGenerateButton().addActionListener(this);

        Utils.centerWindow(mainJFrame);
        mainJFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println ("Inside MainJFrameController::actionPerformed");

        // Handle actions for the components in each tab
        if (event.getSource().equals(mainJFrame.getDailyAdSpendSubmitButton()))
            dailyAdSpendSubmitButton_actionPerformed(event);
        else if (event.getSource().equals(mainJFrame.getPurchaseSubmitButton()))
            purchaseSubmitButton_actionPerformed(event);
        else if (event.getSource().equals(mainJFrame.getReportGenerateButton()))
            reportGenerateButton_actionPerformed(event);
    }

    void dailyAdSpendSubmitButton_actionPerformed(ActionEvent actionEvent) {
        System.out.println("Inside MainJFrameController");
        MessageDialog dlg = new MessageDialog("Submit", "Not Implemented Yet!");
        Utils.centerWindow(dlg);
        dlg.setModal(true);
        dlg.show();
    }

    void purchaseSubmitButton_actionPerformed(ActionEvent actionEvent) {
        System.out.println("Inside MainJFrameController");
        MessageDialog dlg = new MessageDialog("Submit", "Not Implemented Yet!");
        Utils.centerWindow(dlg);
        dlg.setModal(true);
        dlg.show();
    }

    void reportGenerateButton_actionPerformed(ActionEvent actionEvent) {
        System.out.println("Inside MainJFrameController");
        MessageDialog dlg = new MessageDialog("Generate", "Not Implemented Yet!");
        Utils.centerWindow(dlg);
        dlg.setModal(true);
        dlg.show();
    }
}