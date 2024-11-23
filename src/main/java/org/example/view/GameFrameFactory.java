package org.example.view;

import lombok.AllArgsConstructor;
import org.example.models.Board;

import javax.swing.*;

@AllArgsConstructor

public class GameFrameFactory implements FrameFactory {

    private final Board board;

    @Override
    public JFrame createFrame() {
        GameFrame frame = new GameFrame();
        frame.initializeFrame();
        frame.initializeBoardPanel(board);
        return frame;
    }
}
