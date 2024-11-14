package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.controller.interfaces.CellClickInterface;
import org.example.view.CellButton;

@AllArgsConstructor

public class MineCellClickHandler extends CellClickInterface {
    private final GameController gameController;

    @Override
    public void revealCellClick(CellButton cellButton, int row, int column) {
        gameController.endGame(false);
    }

    @Override
    public void flagCellClick(CellButton cellButton, int row, int column) {}
}
