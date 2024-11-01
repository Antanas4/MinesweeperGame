package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
@AllArgsConstructor

public class Cell extends JButton {
    private int adjacentMines;
    private Boolean isRevealed;
    private Boolean isMine;


    public Cell() {
        this.adjacentMines = 0;
        this.isRevealed = false;
        this.isMine = false;
    }

}
