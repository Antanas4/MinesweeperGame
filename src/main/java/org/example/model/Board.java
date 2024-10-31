package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
@AllArgsConstructor

public class Board {
    private final int rows;
    private final int columns;
    private final CellButton[][] cells;
    private final JPanel boardPanel;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new CellButton[rows][columns];
        this.boardPanel = new JPanel(new GridBagLayout());
        initializeBoard();
    }

    public void initializeBoard(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);

        for (int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                cells[i][j] = new CellButton();
                gbc.gridx = j;
                gbc.gridy = i;
                boardPanel.add(cells[i][j], gbc);
            }
        }
    }

}
