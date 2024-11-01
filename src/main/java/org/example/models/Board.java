package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.view.CellButton;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
@AllArgsConstructor

public class Board {
    private final int rows;
    private final int columns;
    private final CellButton[][] cells;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new CellButton[rows][columns];
        initializeBoard();
    }

    public void initializeBoard(){

        for (int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                cells[i][j] = new CellButton(new Cell());
            }
        }
    }

}
