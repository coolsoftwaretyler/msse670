package com.businessinsights.view;

import java.awt.Toolkit;
import java.awt.Component;
import java.awt.Dimension;

public class Utils {

    /**
     * Centers the window
     * @param comp Component
     */
    public static void centerWindow(Component comp) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Dimension frameSize = comp.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        comp.setLocation( (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }
}