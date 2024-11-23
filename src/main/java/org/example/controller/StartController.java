package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.models.Game;
import org.example.view.StartFrame;

import javax.swing.*;



public class StartController {

    public void addActionListeners(StartFrame startFrame) {
        startFrame.getStartButton().addActionListener(e -> loadNewGameWindow());
        startFrame.getExitButton().addActionListener(e -> exitApplication());
    }

    private void loadNewGameWindow() {
        GameController gameController = new GameController();
        gameController.startNewGame();
    }

    private void exitApplication() {
        System.exit(0);
    }

    public void startApplication(JFrame frame) {
        frame.setVisible(true);
    }
}
