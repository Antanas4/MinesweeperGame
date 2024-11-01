package org.example.view;

import org.example.models.Board;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private final Board board;

    public BoardPanel(Board board) {
        this.board = board;
        setLayout(new GridBagLayout());
        initializePanel();
    }

    private void initializePanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);

        for (int i = 0; i < board.getRows(); i++){
            for (int j = 0; j < board.getColumns(); j++){
                CellButton cellButton = board.getCells()[i][j];
                gbc.gridx = j;
                gbc.gridy = i;
                add(cellButton, gbc);
            }
        }
    }
}
