package org.example.controller;

import org.example.models.Board;
import org.example.view.CellButton;

public class BoardController {

    private final Board board;

    public BoardController(Board board) {
        this.board = board;
        addCellClickListeners();
    }

    public void addCellClickListeners() {
        for (int i = 0; i < this.board.getRows(); i++) {
            for (int j = 0; j < this.board.getColumns(); j++) {
                final CellButton cell = this.board.getCells()[i][j];

                if (cell.getCell().getIsMine()) {
                    cell.addActionListener(e -> {
                        cell.addIsBombStyle();
                    });
                } else {
                    cell.addActionListener(e -> {
                        cell.addIsNumberStyle();
                    });
                }
            }
        }
    }
}
