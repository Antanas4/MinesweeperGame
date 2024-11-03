package org.example.controller;

import org.example.models.Game;
import org.example.view.GameFrame;

public class GameController {
    private final GameFrame gameFrame;
    private final Game game;

    public GameController() {
        this.game = new Game();
        this.gameFrame = new GameFrame();
    }

    public void startNewGame() {
        this.gameFrame.initializeFrame();
        this.gameFrame.initializeBoardPanel(game.getBoard());
        this.gameFrame.setVisible(true);
    }
}
