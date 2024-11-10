package org.example;

import org.example.controller.StartController;
import org.example.utils.UIUtils;
import org.example.view.StartFrame;

public class Main {
    public static void main(String[] args) {
        UIUtils.setGlobalLookAndFeel();
        StartFrame startFrame = new StartFrame();
        startFrame.addCustomComponents();

        StartController startController = new StartController(startFrame);

        startController.addActionListeners();
        startController.startApplication();
    }
}