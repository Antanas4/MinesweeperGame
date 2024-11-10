package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.view.CellButton;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor


public class Board {
    private int mineCount;
    private int rows;
    private int columns;
    private final CellButton[][] cells;

    public Board(int rows, int columns, int mineCount) {
        this.mineCount = mineCount;
        this.rows = rows;
        this.columns = columns;
        this.cells = new CellButton[rows][columns];
    }

    public void resetBoard(){
        initializeBoard();
        setMines();
    }

    public void initializeBoard(){
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                cells[i][j] = new CellButton(new Cell(i, j));
                cells[i][j].setEnabled(true);
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
            if (mineLocations.contains(point)){
                continue;
            } else{
                mineLocations.add(point);
                cells[row][column].getCell().setIsMine(true);
                addAdjacentMines(row, column);
            }
        }
    }

    private void addAdjacentMines(Integer row, Integer column) {
        for (int i = row - 1; i < row + 2; i++){
            for (int j = column - 1; j < column + 2; j++){
                if(i < 9 && i > -1 && j < 9 && j > -1){
                    getCells()[i][j].getCell().setAdjacentMines(1);
                }
            }
        }
    }
}
