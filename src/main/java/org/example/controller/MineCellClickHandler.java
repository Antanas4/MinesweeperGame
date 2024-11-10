package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.controller.interfaces.CellClickInterface;
import org.example.view.CellButton;

@AllArgsConstructor

public class MineCellClickHandler implements CellClickInterface {
    private final GameController gameController;

    @Override
    public void handleClick(CellButton cellButton, int row, int column) {
        gameController.endGame(false);
    }
}
