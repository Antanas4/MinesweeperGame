package org.example.view;

import org.example.models.Board;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public void initializeFrame() {
        setTitle("Minesweeper");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void initializeBoardPanel(Board board) {
        BoardPanel boardPanel = new BoardPanel(board);
        JPanel boardContainer = new JPanel();
        boardContainer.setLayout(new BorderLayout());
        boardContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        boardContainer.add(boardPanel, BorderLayout.CENTER);
        setLayout(new BorderLayout());
        add(boardContainer, BorderLayout.CENTER);
    }
}
