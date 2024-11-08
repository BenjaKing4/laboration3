import java.util.Random;


public class TicTacToeModel {
    private char[][] board = new char[3][3];

    public TicTacToeModel() {
        resetBoard();
    }

    // Uppdaterad makeMove-metod som tar emot ett tredje argument (char symbol)
    public boolean makeMove(int row, int col, char symbol) {
        if (board[row][col] == ' ') {
            board[row][col] = symbol; // Sätt symbolen på angiven plats
            return true;
        }
        return false; // Om platsen redan är upptagen, returnera false
    }

    // Metod för att göra datorns drag (kan vara slumpmässigt eller optimalt)
    public void makeComputerMove() {
        // För att hålla det enkelt, välj ett slumpmässigt drag
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (board[row][col] != ' '); // Fortsätt tills ett ledigt fält hittas
        makeMove(row, col, 'O'); // Datorn använder 'O'
    }

    public boolean checkWinner() {
        // Kontrollera alla rader, kolumner och diagonaler för att se om någon har vunnit
        for (int i = 0; i < 3; i++) {
            // Kontrollera rader
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
            // Kontrollera kolumner
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
        }
        // Kontrollera diagonaler
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true; // Om ingen tom ruta finns kvar
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' '; // Sätt alla fält till tomma (' ')
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }
}
