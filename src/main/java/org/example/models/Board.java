package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.view.CellButton;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor


public class Board {
    private final int mineCount;
    private final int rows;
    private final int columns;
    private final CellButton[][] cells;

    public Board(int rows, int columns, int mineCount) {
        this.mineCount = mineCount;
        this.rows = rows;
        this.columns = columns;
        this.cells = new CellButton[rows][columns];
        initializeBoard();
        setMines();
    }

    public void initializeBoard(){
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                cells[i][j] = new CellButton(new Cell(i, j));
            }
        }
    }

    public void setMines(){
        Set<Point> mineLocations = new HashSet<>();
        Random random = new Random();

        while(mineLocations.size() < this.getMineCount()){
            int row = random.nextInt(rows);
            int column = random.nextInt(columns);
            Point point = new Point(row, column);
            System.out.println(row + " " + column);
            if (mineLocations.contains(point)){
                continue;
            } else{
                mineLocations.add(point);
            }
        }


    }

}
