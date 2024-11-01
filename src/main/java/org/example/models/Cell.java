package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Cell {
    private int x;
    private int y;
    private int adjacentMines;
    private Boolean isRevealed;
    private Boolean isMine;


    public Cell(int x, int y) {
        this.adjacentMines = 0;
        this.isRevealed = false;
        this.isMine = false;
    }

}
