package org.example.view;

import javax.swing.*;

public class StartFrameFactory implements FrameFactory {
    @Override
    public JFrame createFrame() {
        StartFrame frame = new StartFrame();
        frame.addCustomComponents();
        return frame;
    }
}
