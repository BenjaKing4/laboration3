import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeModelTest {

    @Test
    void makewhileMove() {
        TicTacToeModel model = new TicTacToeModel();
        model.makeMove(1, 1,'x');
        assertEquals('x', model.getBoard()[1][1]);
    }


}