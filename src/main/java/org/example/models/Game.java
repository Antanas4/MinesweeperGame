package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Game {
    private final int ROWS = 9;
    private final int COLUMNS = 9;
    private final int MINES = 10;
    private int userScore;

}
