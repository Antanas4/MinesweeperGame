package org.example.controller;

import org.example.models.Game;
import org.example.view.GameFrame;
import org.example.models.Board;

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
            System.out.println("You lost");
            boardController.revealMineCells();
            boardController.disableCells();
            gameFrame.showGameOverDialog(this);
        }
    }

    public void exitGameWindow() {
        StartController startController = new StartController();
        gameFrame.dispose();
        startController.startApplication();
    }
}

//tvarkyti exitGameWindow ir startNewGame
