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


    public Cell(int x, int y) {
        this.adjacentMines = 0;
        this.isRevealed = false;
        this.isMine = false;
    }

    public void setAdjacentMines(int adjacentMinesToAdd) {
        if (!this.getIsMine()){
            this.adjacentMines += adjacentMinesToAdd;
        }
    }
}

