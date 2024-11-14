package org.example.controller;

import org.example.controller.interfaces.CellClickInterface;
import org.example.view.CellButton;

public class flagCellClick extends CellClickInterface {

    @Override
    public void revealCellClick(CellButton cellButton, int row, int column) {}

    @Override
    public void flagCellClick(CellButton cellButton, int row, int column) {
        if (!cellButton.getCell().getIsFlagged() && !cellButton.getCell().getIsRevealed()){
            cellButton.getCell().setIsFlagged(true);
            cellButton.addIsFlagStyle();
        } else if (!cellButton.getCell().getIsRevealed()){
            cellButton.getCell().setIsFlagged(false);
            cellButton.addIsDefaultStyle();
        }
    }
}
