package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.view.CellButton;

@AllArgsConstructor

class SafeCellClickStrategy extends CellClickStrategy {
    private final BoardController boardController;
    private final GameController gameController;

    @Override
    public void handleCellClick(CellButton cell, int row, int column) {
        cell.addIsNumberStyle();
        if (cell.getCell().getAdjacentMines() == 0){
            boardController.revealZeroAdjacentCells(row, column);
        } else{
            cell.getCell().setIsRevealed(true);
        }
        if(boardController.playerWon()){
            gameController.endGame(true);
        }
    }
}
