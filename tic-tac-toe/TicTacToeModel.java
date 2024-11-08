import java.util.Random;

public class TicTacToeModel {
    private char[][] board = new char[3][3];

    public TicTacToeModel() {
        resetBoard();
    }

    public boolean makeMove(int row, int col, char player) {
        // Kolla om spelet redan är över (vinst eller oavgjort)
        if (checkWinner() != ' ' || isBoardFull()) {
            return false;  // Om det redan finns en vinnare eller om brädet är fullt, tillåt inte ett drag
        }

        if (board[row][col] == ' ') {  // Om rutan är tom
            board[row][col] = player;  // Gör draget
            return true;  // Draget lyckades
        }
        return false;  // Rutan är upptagen
    }



    public void makeComputerMove() {
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (board[row][col] != ' ');
        makeMove(row, col, 'O');
    }

    public char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return board[i][0];  // Vinnare hittad
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return board[0][i];  // Vinnare hittad
            }
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return board[0][0];  // Vinnare hittad
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return board[0][2];  // Vinnare hittad
        }
        return ' ';  // Ingen vinnare
    }



    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isDraw() {
        return isBoardFull() && checkWinner() == ' '; // Om brädet är fullt och ingen har vunnit
    }



    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }
}
