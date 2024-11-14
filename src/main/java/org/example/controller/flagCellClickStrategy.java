package org.example.controller;

import org.example.view.CellButton;

class flagCellClickStrategy extends CellClickStrategy {

    @Override
    public void handleCellClick(CellButton cell, int row, int column) {
        if (!cell.getCell().getIsFlagged() && !cell.getCell().getIsRevealed()){
            cell.getCell().setIsFlagged(true);
            cell.addIsFlagStyle();
        } else if (!cell.getCell().getIsRevealed()){
            cell.getCell().setIsFlagged(false);
            cell.addIsDefaultStyle();
        }
    }
}
