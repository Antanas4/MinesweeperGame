package org.example.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.models.Board;
import org.example.view.CellButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

@Getter
@Setter

public class BoardController {
    private Board board;

    public BoardController(Board board) {
        this.board = board;
    }

    public void initializeBoardControlls(GameController gameController) {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                final CellButton cellButton = this.board.getCells()[i][j];
                final int finalI = i;
                final int finalJ = j;
                addCellClickListeners(cellButton, gameController, finalI, finalJ);
            }
        }
    }

//    Polimorfizmas
    public void addCellClickListeners(CellButton cellButton, GameController gameController, int row, int column) {
        cellButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent event) {
                CellClickStrategy strategy = determinCellClickStrategy(cellButton, gameController, event);
                strategy.handleCellClick(cellButton, row, column);
            }
        });
    }

    private CellClickStrategy determinCellClickStrategy(CellButton cellButton, GameController gameController, MouseEvent event) {
        if (SwingUtilities.isRightMouseButton(event)) {
            return new flagCellClickStrategy();
        } else if (SwingUtilities.isLeftMouseButton(event)) {
            if (cellButton.getCell().getIsMine()){
                return new MineCellClickStrategy(gameController);
            } else {
                return new SafeCellClickStrategy(this, gameController);
            }
        }
        return new DefaultCellClickStrategy();
    }


    public void revealZeroAdjacentCells ( int row, int col){
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

        public void revealMineCells () {
            for (int i = 0; i < board.getRows(); i++) {
                for (int j = 0; j < board.getColumns(); j++) {
                    final CellButton cell = this.board.getCells()[i][j];
                    if (cell.getCell().getIsMine()) {
                        cell.addIsBombStyle();
                    }
                }
            }
        }

        public void disableCells () {
            for (int i = 0; i < board.getRows(); i++) {
                for (int j = 0; j < board.getColumns(); j++) {
                    final CellButton cell = this.board.getCells()[i][j];
                    if (!cell.getCell().getIsMine()) {
                        cell.setEnabled(false);
                    }
                }
            }
        }

        public boolean playerWon () {
            int revealedCellCounter = 0;
            for (int i = 0; i < board.getRows(); i++) {
                for (int j = 0; j < board.getColumns(); j++) {
                    if (board.getCells()[i][j].getCell().getIsRevealed()) {
                        revealedCellCounter++;
                    }
                }
            }
            return revealedCellCounter == board.getCellsToReveal();
        }
    }
