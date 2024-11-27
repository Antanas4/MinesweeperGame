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
        setPreferredSize(new Dimension(50, 50));
        setBorderPainted(true);
        setOpaque(true);
        setBackground(new Color(76, 84, 92));
    }

    public void addIsBombStyle(){
        setText("\uD83D\uDCA3");
        setBackground(Color.LIGHT_GRAY);
    }

    public void addIsNumberStyle(){
        setText(String.valueOf(cell.getAdjacentMines()));
        setBackground(Color.LIGHT_GRAY);
        setEnabled(false);
    }

    public void addIsFlagStyle() {
        setText("F");
    }

    public void addIsDefaultStyle() {
        setText("");
    }
}
