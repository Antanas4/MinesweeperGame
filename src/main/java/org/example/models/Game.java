package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Game {
    private final Board board;

    public Game() {
        StartModel startModel = new StartModel();
        this.board = new Board(startModel.getRows(), startModel.getColumns(), startModel.getMineCount());
    }

}
