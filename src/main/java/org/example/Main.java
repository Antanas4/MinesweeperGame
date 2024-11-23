package org.example;

import org.example.controller.StartController;
import org.example.utils.UIUtils;
import org.example.view.StartFrame;
import org.example.view.StartFrameFactory;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UIUtils.setGlobalLookAndFeel();
        StartFrameFactory startFrameFactory = new StartFrameFactory();
        JFrame startFrame = startFrameFactory.createFrame();
        StartController startController = new StartController();
        startController.addActionListeners((StartFrame) startFrame);
        startController.startApplication(startFrame);
    }
}