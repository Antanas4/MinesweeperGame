package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.controller.interfaces.CellClickInterface;
import org.example.view.CellButton;

@AllArgsConstructor

public class NumberCellClickHandler implements CellClickInterface {

    private final BoardController boardController;

    @Override
    public void handleClick(CellButton cellButton, int row, int column) {
        cellButton.addIsNumberStyle();
        if (cellButton.getCell().getAdjacentMines() == 0){
            boardController.revealZeroAdjacentCells(row, column);
        } else{
            cellButton.getCell().setIsRevealed(true);
        }
        if(boardController.playerWon()){
            System.out.println("Player won");
        }
    }
}
