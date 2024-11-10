package org.example.controller;

import org.example.view.StartFrame;

public class StartController {
    private final StartFrame startFrame;
    private final GameController gameController;

    public StartController(StartFrame startFrame, GameController gameController) {
        this.startFrame = startFrame;
        this.gameController = gameController;
    }

    public void addActionListeners() {
        startFrame.getStartButton().addActionListener(e -> startNewGame());
        startFrame.getExitButton().addActionListener(e -> exitApplication());
    }

    private void startNewGame() {
        startFrame.dispose();
        gameController.startNewGame();
    }

    private void exitApplication() {
        System.exit(0);
    }

    public void startApplication() {
        this.startFrame.setVisible(true);
    }
}
