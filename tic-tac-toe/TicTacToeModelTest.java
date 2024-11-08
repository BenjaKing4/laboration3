import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeModelTest {

    @Test
    void makewhileMove() {
        TicTacToeModel model = new TicTacToeModel();
        boolean moveSuccessful = model.makeMove(1, 1, 'x');
        assertTrue(moveSuccessful);
        assertEquals('x', model.getBoard()[1][1]);
    }

    @Test
    void testOccupiedMove() {
        TicTacToeModel model = new TicTacToeModel();

        boolean moveSuccessfulX = model.makeMove(1, 1, 'x');
        assertTrue(moveSuccessfulX);
        assertEquals('x', model.getBoard()[1][1]);

        boolean moveSuccessfulO = model.makeMove(1, 1, 'o');
        assertFalse(moveSuccessfulO);
        assertEquals('x', model.getBoard()[1][1]);
    }

    @Test
    void testWinnerRow() {
        TicTacToeModel model = new TicTacToeModel();

        // Spelare 'x' gör drag för att vinna på en rad
        model.makeMove(1, 0, 'x');
        model.makeMove(1, 1, 'x');
        model.makeMove(1, 2, 'x');

        // Kontrollera att 'x' är vinnaren
        assertEquals('x', model.checkWinner(), "Player 'x' should be the winner");
    }



    @Test
    void testWinnerColumn() {
        TicTacToeModel model = new TicTacToeModel();
        model.makeMove(0, 0, 'o');
        model.makeMove(1, 0, 'o');
        model.makeMove(2, 0, 'o');

        // Kontrollera att 'o' är vinnarenassertTrue(model.checkWinner(), "Player 'o' should be the winner");
    }

    @Test
    void testWinnerDiagonal() {
        TicTacToeModel model = new TicTacToeModel();
        model.makeMove(0, 0, 'x');
        model.makeMove(1, 1, 'x');
        model.makeMove(2, 2, 'x');

        // Kontrollera att 'x' är vinnaren
        assertEquals('x', model.checkWinner(), "Player 'x' should be the winner");
    }

    @Test
    void testNoWinner() {
        TicTacToeModel model = new TicTacToeModel();

        // Gör några drag utan att någon vinner
        model.makeMove(0, 0, 'x');
        model.makeMove(1, 1, 'o');
        model.makeMove(2, 2, 'x');

        // Kontrollera att det inte finns någon vinnare än
        assertEquals(' ', model.checkWinner(), "There should be no winner yet");
    }


    @Test
    void testDraw() {
        TicTacToeModel model = new TicTacToeModel();

        // Fyll brädet utan att någon vinner
        model.makeMove(0, 0, 'X');
        model.makeMove(0, 1, 'O');
        model.makeMove(0, 2, 'X');
        model.makeMove(1, 0, 'O');
        model.makeMove(1, 1, 'X');
        model.makeMove(1, 2, 'O');
        model.makeMove(2, 0, 'O');
        model.makeMove(2, 1, 'X');
        model.makeMove(2, 2, 'O');

        // Kontrollera om spelet är oavgjort
        assertTrue(model.isDraw(), "The game should be a draw.");
    }




    @Test
    void testMoveAfterGameOver() {
        TicTacToeModel model = new TicTacToeModel();

        // Gör några drag som leder till en vinst
        model.makeMove(1, 0, 'x');
        model.makeMove(1, 1, 'x');
        model.makeMove(1, 2, 'x');

        // Kontrollera att spelaren 'x' har vunnit
        assertEquals('x', model.checkWinner(), "Player 'x' should win.");

        // Försök att göra ett drag efter att spelet har slutat
        boolean moveAfterWin = model.makeMove(0, 0, 'o');
        assertFalse(moveAfterWin, "Should not be able to make a move after the game is over.");
    }

}
