package org.example.controller;

import org.example.models.Game;
import org.example.models.StartModel;
import org.example.view.GameFrame;

import java.awt.*;

public class GameController {
    private final GameFrame gameFrame;
    private final Game game;

    public GameController() {
        this.game = new Game();
        this.gameFrame = new GameFrame();
    }

    public void startNewGame() {
        gameFrame.initializeFrame();
        gameFrame.initializeBoardPanel(game.getBoard());
        this.gameFrame.setVisible(true);
    }


}
