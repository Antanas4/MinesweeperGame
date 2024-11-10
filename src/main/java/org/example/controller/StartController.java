package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.models.Game;
import org.example.view.StartFrame;

@NoArgsConstructor
@AllArgsConstructor

public class StartController {
    private StartFrame startFrame;


    public void addActionListeners() {
        startFrame.getStartButton().addActionListener(e -> loadNewGameWindow());
        startFrame.getExitButton().addActionListener(e -> exitApplication());
    }

    private void loadNewGameWindow() {
        GameController gameController = new GameController();
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
