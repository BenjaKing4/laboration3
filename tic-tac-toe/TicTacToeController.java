public class TicTacToeController {
    private TicTacToeModel model;
    private TicTacToeView view;
    private int playerScore = 0;
    private int computerScore = 0;

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        this.model = model;
        this.view = view;
    }

    public void handlePlayerMove(int row, int col) {
        if (model.makeMove(row, col, 'X')) {  // Spelaren använder 'X'
            view.updateBoard(model.getBoard());
            if (model.checkWinner()) {
                playerScore++; // Spelaren vinner
                view.showWinner("Spelaren");
                view.showScores(playerScore, computerScore);
                model.resetBoard();
            } else if (model.isBoardFull()) {
                view.showDraw();
                model.resetBoard();
            } else {
                handleComputerMove(); // Datorns tur
            }
        }
    }

    public void handleComputerMove() {
        model.makeComputerMove();  // Datorns drag
        view.updateBoard(model.getBoard());
        if (model.checkWinner()) {
            computerScore++; // Datorn vinner
            view.showWinner("Datorn");
            view.showScores(playerScore, computerScore);
            model.resetBoard();
        } else if (model.isBoardFull()) {
            view.showDraw();
            model.resetBoard();
        }
    }

    public void restartGame() {
        model.resetBoard();
        view.updateBoard(model.getBoard());
    }

    public void quitGame() {
        System.exit(0); // Avsluta spelet
    }
}
