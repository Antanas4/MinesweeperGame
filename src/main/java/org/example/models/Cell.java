package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Cell {
    private int row;
    private int column;
    private int adjacentMines;
    private Boolean isRevealed;
    private Boolean isMine;
    private Boolean isFlagged;


    public Cell(int row, int column) {
        this.adjacentMines = 0;
        this.isRevealed = false;
        this.isMine = false;
        this.row = row;
        this.column = column;
        this.isFlagged = false;
    }

    public void setAdjacentMines(int adjacentMinesToAdd) {
        if (!this.getIsMine()){
            adjacentMines += adjacentMinesToAdd;
        }
    }
}

