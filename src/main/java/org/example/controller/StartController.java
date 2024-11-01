package org.example.controller;

import org.example.view.StartFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController {
    private final StartFrame startFrame;

    public StartController(StartFrame startFrame) {
        this.startFrame = startFrame;
        addActionListeners();
    }

    private void addActionListeners() {
        startFrame.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameController gameController = new GameController();
                startFrame.dispose();
                gameController.startNewGame();
            }
        });

        startFrame.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exit button clicked");
                System.exit(0);
            }
        });
    }
}
