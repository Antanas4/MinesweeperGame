package org.example.controller;

import org.example.view.CellButton;

//abstrakcija
abstract class CellClickStrategy {
    public abstract void handleCellClick(CellButton cell, int row, int column);
}
