package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Game {
    private final int rows;
    private final int columns;
    private final int mines;

    private final Board board;

    public Game() {
        this.rows = 9;
        this.columns = 9;
        this.mines = 10;
        this.board = new Board(this.rows, this.columns, this.mines);
    }

}
