package org.example.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class StartModel {
    private final int rows;
    private final int columns;
    private final int mineCount;

    public StartModel() {
        this.rows = 9;
        this.columns = 9;
        this.mineCount = 10;
    }

}
