package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.controller.BoardController;

@Getter
@Setter

public class Game {
    private final int ROWS = 9;
    private final int COLUMNS = 9;
    private final int MINES = 10;

    private final Board board;
    private final BoardController boardController;

    public Game() {
        this.board = new Board(this.ROWS, this.COLUMNS, this.MINES);
        this.boardController = new BoardController(this.board);
    }

}
