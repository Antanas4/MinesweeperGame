import org.example.controller.BoardController;
import org.example.models.Board;
import org.example.view.CellButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BoardControllerTest {
    private BoardController boardController;
    private Board board;

    @BeforeEach
    void setUp(){
        int rows = 9;
        int columns = 9;
        int totalMines = 10;
        board = new Board(rows, columns, totalMines);
        board.resetBoard();
        boardController = new BoardController(board);
    }

    @Test
    public void testPlayerWon_AllCellsRevealed(){
        CellButton cells[][] = board.getCells();
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (!board.getCells()[i][j].getCell().getIsMine()){
                    board.getCells()[i][j].getCell().setIsRevealed(true);
                }
            }
        }
        boolean result = boardController.playerWon();
        assertTrue(result, "Player should win when all non-mine cells are revealed.");
    }

    @Test
    public void testPlayerWon_NoneCellsRevealed(){

        CellButton cells[][] = board.getCells();
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (!board.getCells()[i][j].getCell().getIsMine()){
                    board.getCells()[i][j].getCell().setIsRevealed(false);
                }
            }
        }
        boolean result = boardController.playerWon();
        assertFalse(result, "Player should not win when not all non-mine cells are revealed.");
    }
}
