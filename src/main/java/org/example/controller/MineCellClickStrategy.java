package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.view.CellButton;

@AllArgsConstructor

class MineCellClickStrategy extends CellClickStrategy {
    private final GameController gameController;

    @Override
    public void handleCellClick(CellButton cell, int row, int column) {
        gameController.endGame(false);
    }
}
