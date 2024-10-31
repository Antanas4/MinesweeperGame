package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
@AllArgsConstructor

public class CellButton extends JButton {
    private int adjacentMines;
    private Boolean isRevealed;
    private Boolean isMine;


    public CellButton() {
        setPreferredSize(new Dimension(30, 30));
        setBorderPainted(true);
        this.adjacentMines = 0;
        this.isRevealed = false;
        this.isMine = false;
    }
}
