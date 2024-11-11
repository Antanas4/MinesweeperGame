package org.example.controller.interfaces;

import org.example.view.CellButton;

public interface CellClickInterface {
    void revealCellClick(CellButton cellButton, int row, int column);
    void flagCellClick(CellButton cellButton, int row, int column);
}
