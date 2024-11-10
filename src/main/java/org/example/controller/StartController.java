package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.view.StartFrame;

@NoArgsConstructor
@AllArgsConstructor

public class StartController {
    private StartFrame startFrame;
    private GameController gameController;

    public void addActionListeners() {
        startFrame.getStartButton().addActionListener(e -> loadNewGameWindow());
        startFrame.getExitButton().addActionListener(e -> exitApplication());
    }

    private void loadNewGameWindow() {
        startFrame.dispose();
        gameController.startNewGame();
    }

    private void exitApplication() {
        System.exit(0);
    }

    public void startApplication() {
        startFrame.setVisible(true);
    }
}
