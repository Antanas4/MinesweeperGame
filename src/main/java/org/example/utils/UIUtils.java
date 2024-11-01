package org.example.utils;

import javax.swing.*;

public class UIUtils {
    public static void setGlobalLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
