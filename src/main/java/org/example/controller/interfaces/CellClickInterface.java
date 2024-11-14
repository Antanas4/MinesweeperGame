package org.example.controller.interfaces;

import org.example.view.CellButton;

public abstract class CellClickInterface {
    public abstract void revealCellClick(CellButton cellButton, int row, int column);
    public abstract void flagCellClick(CellButton cellButton, int row, int column);
}
