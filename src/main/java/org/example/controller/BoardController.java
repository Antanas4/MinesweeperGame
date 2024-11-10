package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.models.Board;
import org.example.view.CellButton;

@Getter
@Setter

public class BoardController {

    private Board board;

    public BoardController(Board board) {
        this.board = board;
    }

    public void addCellClickListeners() {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
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
