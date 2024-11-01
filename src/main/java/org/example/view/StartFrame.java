package org.example.view;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter

public class StartFrame extends JFrame {
    private JLabel welcomeLabel;
    private JButton startButton;
    private JButton exitButton;

    public StartFrame() {
        setTitle("Minesweeper");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        welcomeLabel = new JLabel("Welcome To Minesweeper");
        startButton = new JButton("New Game");
        exitButton = new JButton("Exit Game");

        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setPreferredSize(new Dimension(150, 40));
        exitButton.setPreferredSize(new Dimension(150, 40));

        setLayout(new GridBagLayout());
        addCustomComponents();
    }

    private void addCustomComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        add(getStartButton(), gbc);
        add(getExitButton(), gbc);
        add(getWelcomeLabel(), gbc);
    }
}
