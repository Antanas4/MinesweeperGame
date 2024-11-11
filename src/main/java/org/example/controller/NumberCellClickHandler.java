package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.controller.interfaces.CellClickInterface;
import org.example.view.CellButton;



public class NumberCellClickHandler implements CellClickInterface {

    private final BoardController boardController;
    private final GameController gameController;

    public NumberCellClickHandler(BoardController boardController, GameController gameController) {
        this.boardController = boardController;
        this.gameController = gameController;
    }

    @Override
    public void revealCellClick(CellButton cellButton, int row, int column) {
        cellButton.addIsNumberStyle();
        if (cellButton.getCell().getAdjacentMines() == 0){
            boardController.revealZeroAdjacentCells(row, column);
        } else{
            cellButton.getCell().setIsRevealed(true);
        }
        if(boardController.playerWon()){
            gameController.endGame(true);
        }
    }

    @Override
    public void flagCellClick(CellButton cellButton, int row, int column) {}
}
