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

    public void loadGameFrame() {
        boardController.getBoard().resetBoard();
        boardController.addCellClickListeners();
        gameFrame.initializeFrame();
        gameFrame.initializeBoardPanel(boardController.getBoard());
        gameFrame.setVisible(true);
    }
}
