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
        String endGameMessage = playerWon ? "You won!" : "You lost!";
        if (!playerWon) {
            boardController.revealMineCells();
        }
        boardController.disableCells();
        gameFrame.showGameOverDialog(endGameMessage);
    }

    public void exitGameWindow() {
        StartFrame startFrame = new StartFrame();
        startFrame.addCustomComponents();
        StartController startController = new StartController(startFrame);
        startController.addActionListeners();
        startController.startApplication();
    }
}

