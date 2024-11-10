package org.example.controller;

import org.example.models.Game;
import org.example.view.GameFrame;
import org.example.models.Board;
import org.example.view.StartFrame;

public class GameController {
    private final GameFrame gameFrame;
    private final BoardController boardController;

    public GameController() {
        Game game = new Game();
        Board board = new Board(game.getROWS(), game.getCOLUMNS(), game.getMINES());
        this.boardController = new BoardController(board);
        this.gameFrame = new GameFrame();
    }

    public void startNewGame() {
        boardController.getBoard().resetBoard();
        boardController.addCellClickListeners(this);
        gameFrame.initializeFrame();
        gameFrame.initializeBoardPanel(boardController.getBoard());
        gameFrame.setVisible(true);
    }

    public void endGame(boolean playerWon) {
        if (playerWon) {
            System.out.println("You won");
        } else {
            boardController.revealMineCells();
            boardController.disableCells();
            gameFrame.showGameOverDialog();
        }
    }

    public void exitGameWindow() {
        gameFrame.dispose();
        StartFrame startFrame = new StartFrame();
        startFrame.addCustomComponents();
        StartController startController = new StartController(startFrame);
        startController.addActionListeners();
        startController.startApplication();
    }
}

// pertvarkyti endGame ir startNewGame
//gameControllerip constructoriuj turbut nereiketu kurti naujo board'o
