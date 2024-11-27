package org.example.controller;

import org.example.models.Game;
import org.example.view.GameFrame;
import org.example.models.Board;
import org.example.view.GameFrameFactory;
import org.example.view.StartFrame;
import org.example.view.StartFrameFactory;

import javax.swing.*;
import java.awt.*;

public class GameController {
    private final GameFrame gameFrame;
    private final BoardController boardController;
    private final GameFrameFactory factory;

    public GameController() {
        Game game = new Game();
        Board board = new Board(game.getROWS(), game.getCOLUMNS(), game.getMINES());
        factory = new GameFrameFactory(board);
        boardController = new BoardController(board);
        gameFrame = new GameFrame();
    }

    public void startNewGame() {
        disposeAllWindows();
        boardController.getBoard().resetBoard();
        boardController.initializeBoardControlls(this);
        JFrame gameFrame = factory.createFrame();
        gameFrame.setVisible(true);
    }

    public void endGame(boolean playerWon) {
        String endGameMessage = playerWon ? "You won!" : "You lost!";
        if (!playerWon) {
            boardController.revealMineCells();
        }
        boardController.disableCells();
        gameFrame.showGameOverDialog(endGameMessage, this);
    }

    public void exitGameWindow() {
        StartFrameFactory startFrameFactory = new StartFrameFactory();
        JFrame startFrame = startFrameFactory.createFrame();
        StartController startController = new StartController();
        startController.addActionListeners((StartFrame) startFrame);
        startController.startApplication(startFrame);
    }

    public void disposeAllWindows(){
        for (Window window : Window.getWindows()) {
            if (window.isShowing()) {
                window.dispose();
            }
        }
    }
}

