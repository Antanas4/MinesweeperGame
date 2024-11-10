package org.example.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.controller.interfaces.CellClickInterface;
import org.example.models.Board;
import org.example.view.CellButton;

import javax.swing.*;
import java.awt.*;
import java.util.*;

@Getter
@Setter

public class BoardController {
    private Board board;

    public BoardController(Board board) {
        this.board = board;
    }

    public void addCellClickListeners(GameController gameController) {
        CellClickInterface mineCellHandler = new MineCellClickHandler(gameController);
        CellClickInterface numberCellHandler = new NumberCellClickHandler(this);

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                final CellButton cellButton = this.board.getCells()[i][j];
                if (cellButton.getCell().getIsMine()) {
                    int finalI = i;
                    int finalJ = j;
                    cellButton.addActionListener(_ -> mineCellHandler.handleClick(cellButton, finalI, finalJ));
                } else {
                    int finalI1 = i;
                    int finalJ1 = j;
                    cellButton.addActionListener(_ -> numberCellHandler.handleClick(cellButton, finalI1, finalJ1));
                }
            }
        }
    }

    public void revealZeroAdjacentCells(int row, int col) {
        Queue<Point> toReveal = new LinkedList<>();
        toReveal.add(new Point(row, col));

        while (!toReveal.isEmpty()) {
            Point point = toReveal.poll();
            int r = point.x;
            int c = point.y;

            if (r < 0 || r >= board.getRows() || c < 0 || c >= board.getColumns()) {
                continue;
            }

            final CellButton cell = this.board.getCells()[r][c];
            if (cell.getCell().getIsRevealed()) {
                continue;
            }

            cell.getCell().setIsRevealed(true);

            SwingUtilities.invokeLater(cell::addIsNumberStyle);

            if (cell.getCell().getAdjacentMines() == 0) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (!(i == 0 && j == 0)) {
                            toReveal.add(new Point(r + i, c + j));
                        }
                    }
                }
            }
        }
    }

    public void revealMineCells() {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                final CellButton cell = this.board.getCells()[i][j];
                if (cell.getCell().getIsMine()) {
                    cell.addIsBombStyle();
                }
            }
        }
    }

    public void disableCells() {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                final CellButton cell = this.board.getCells()[i][j];
                if (!cell.getCell().getIsMine()) {
                    cell.setEnabled(false);
                }
            }
        }
    }

    public boolean playerWon() {
        int revealedCellCounter = 0;
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if(board.getCells()[i][j].getCell().getIsRevealed()) {
                    revealedCellCounter++;
                }
            }
        }
        return revealedCellCounter <= board.getCellsToReveal();
    }
}
