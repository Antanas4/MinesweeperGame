package org.example.view;

import lombok.Getter;
import lombok.Setter;
import org.example.models.Cell;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter

public class CellButton extends JButton {
    private final Cell cell;

    public CellButton(Cell cell) {
        this.cell = cell;
        setPreferredSize(new Dimension(30, 30));
        setBorderPainted(true);
        setOpaque(true);
        setBackground(new Color(76, 84, 92));
    }
}
