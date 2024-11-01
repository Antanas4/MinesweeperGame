package org.example.actions;

import org.example.view.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Starting new game");
        GameFrame frame = new GameFrame();
        frame.setVisible(true);

        JFrame startFrame = (JFrame) SwingUtilities.getWindowAncestor((JButton) e.getSource());
        startFrame.dispose();
    }
}
