package org.example;

import org.example.view.GameFrame;
import org.example.utils.UIUtils;

public class Main {

    public static void main(String[] args) {
        UIUtils.setGlobalLookAndFeel();
        GameFrame startFrame = new GameFrame();
        startFrame.setVisible(true);
    }
}