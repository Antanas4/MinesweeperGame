package org.example.controller;

import org.example.models.Board;


public class BoardController {

    public void addCellClickListener(Board board) {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                final int row = i;
                final int col = j;

                board.getCells()[row][col].addActionListener(e -> {
                    if (board.getCells()[row][col].getCell().getIsMine()){
                        System.out.println("BOOM");
                    } else{
                        System.out.println("NOT BOOM");
                    }
                });
            }
        }
    }
    }
