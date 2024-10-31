package org.example.frames;

import org.example.actions.ExitGame;
import org.example.actions.NewGame;

import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame {
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    private static final String TITLE = "Minesweeper";

    public StartFrame() {
        renderFrame();
        addCustomComponents();
    }
    public void renderFrame(){
        setTitle(TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void addCustomComponents() {
        JLabel welcomeLabel = new JLabel("Welcome To Minesweeper");
        JButton startButton = new JButton("New Game");
        JButton exitButton = new JButton("Exit");
        NewGame newGame = new NewGame();
        ExitGame exitGame = new ExitGame();


        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setPreferredSize(new Dimension(150, 40));
        exitButton.setPreferredSize(new Dimension(150, 40));

        startButton.addActionListener(newGame);
        exitButton.addActionListener(exitGame);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        add(welcomeLabel, gbc);

        gbc.gridy = 1;
        add(startButton, gbc);

        gbc.gridy = 2;
        add(exitButton, gbc);

        renderFrame();
    }



}
