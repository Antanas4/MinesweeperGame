package org.example.view;

import org.example.models.Board;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    private static final String TITLE = "Minesweeper";

    public GameFrame() {
        initializeFrame();
    }

    public void initializeFrame(){
        setTitle(TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Board board = new Board(9, 9);
        BoardPanel boardPanel = new BoardPanel(board);

        JPanel boardContainer = new JPanel();
        boardContainer.setLayout(new BorderLayout());
        boardContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        boardContainer.add(boardPanel, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(boardContainer, BorderLayout.CENTER);
    }
}
