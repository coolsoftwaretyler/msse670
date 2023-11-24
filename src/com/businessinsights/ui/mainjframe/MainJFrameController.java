package com.businessinsights.ui.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.businessinsights.ui.MessageDialog;
import com.businessinsights.ui.Utils;

/**
 * MainJFrameController.java
 *
 * Listens and handles actions generated from MainJFrame.java
 *
 * @author Mike.Prasad
 */

public class MainJFrameController
        implements ActionListener
{

    private MainJFrame mainJFrame;

    /** Creates a new instance of MainJFrameController */
    public MainJFrameController() {
    }


    /*
     * Copy constructor
     */

    public MainJFrameController (MainJFrame mainJFrame)
    {
        this.mainJFrame = mainJFrame;

        //add all the action listeners here
        mainJFrame.getFileMenuItem().addActionListener(this);
        mainJFrame.getDatabaseMenuItem().addActionListener(this);
        mainJFrame.getSubmitButton().addActionListener(this);

        // center the frame
        Utils.centerWindow(mainJFrame);
        mainJFrame.setVisible(true);
    }

    /*
     *  (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent event)
    {

        System.out.println ("Inside MainJFrameController::actionPerformed");

        if (event.getSource().equals(mainJFrame.getFileMenuItem()))
            menuFileOpen_actionPerformed(event);
        else if (event.getSource().equals(mainJFrame.getDatabaseMenuItem()))
            menuReadDB_actionPerformed(event);
        else if (event.getSource().equals(mainJFrame.getSubmitButton()))
            submitButton_actionPerformed(event);
    }

    /**
     * Processes File Menu | Data | Open from File action
     *
     * @param actionEvent ActionEvent
     */
    void menuFileOpen_actionPerformed(ActionEvent actionEvent)
    {

        /*
         * In reality, one would call the controller - BusinessInsightsController to
         *  exercise the appropriate service. See submitButton_actionPerformed
         *  for example.
         */
        MessageDialog dlg = new MessageDialog( "File Open", " Read comments in callback code");
        Utils.centerWindow(dlg);
        dlg.setModal(true);
        dlg.show();

        return;
    } //end menuFileOpen_actionPerformed


    /**
     * Processes File Menu | Data | Open from Database menu click action
     *
     * @param actionEvent ActionEvent
     */
    void menuReadDB_actionPerformed (ActionEvent actionEvent)
    {

        /*
         * In reality, one would call the controller - BusinessInsightsController to
         *  exercise the appropriate service. See submitButton_actionPerformed
         *  for example.
         */
        MessageDialog dlg = new MessageDialog( "File Open", " Read comments in callback code");
        Utils.centerWindow(dlg);
        dlg.setModal(true);
        dlg.show();

        return;
    } //end menuReadDB_actionPerformed


    /**
     * Processes Submit button action
     *
     * @param actionEvent ActionEvent
     */
    void submitButton_actionPerformed(ActionEvent actionEvent)
    {
        System.out.println("Inside MainJFrameController");
        MessageDialog dlg = new MessageDialog( "Submit", "Not Implemented Yet!");
        Utils.centerWindow(dlg);
        dlg.setModal(true);
        dlg.show();

        return;
    } //end submitButton_actionPerformed

} //end class