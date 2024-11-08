import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TicTacToeView {
    private Button[][] buttons = new Button[3][3];
    private Button restartButton;
    private Button quitButton;
    private VBox layout;
    private Text scoreText;

    public Scene createScene(TicTacToeController controller) {
        GridPane grid = new GridPane();

        // Skapa 3x3 knappar för spelplanen
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button(" ");
                button.setMinSize(100, 100);
                final int r = row;
                final int c = col;
                button.setOnAction(e -> controller.handlePlayerMove(r, c));
                buttons[row][col] = button;
                grid.add(button, col, row);
            }
        }

        // Skapa knapparna för "Spela igen" och "Avsluta"
        restartButton = new Button("Spela igen");
        quitButton = new Button("Avsluta");

        restartButton.setOnAction(e -> controller.restartGame());
        quitButton.setOnAction(e -> controller.quitGame());

        // Skapa en HBox för knapparna "Spela igen" och "Avsluta"
        HBox buttonLayout = new HBox(10, restartButton, quitButton);
        buttonLayout.setSpacing(10); // Justera avståndet mellan knapparna

        // Lägg till en Text för att visa poängen
        scoreText = new Text("Spelare: 0 - Dator: 0");

        // Lägg till knappar och poängtexten i VBox
        layout = new VBox(10, grid, buttonLayout, scoreText); // Lägg till poängen här
        return new Scene(layout, 300, 350);
    }

    public void updateBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText(String.valueOf(board[row][col]));
            }
        }
    }

    public void showWinner(String winner) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Spel avslutat");
        alert.setHeaderText(null);
        alert.setContentText(winner + " har vunnit!");
        alert.showAndWait();
    }

    public void showDraw() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Spel avslutat");
        alert.setHeaderText(null);
        alert.setContentText("Oavgjort!");
        alert.showAndWait();
    }

    public void showScores(int playerScore, int computerScore) {
        scoreText.setText("Spelare: " + playerScore + " - Dator: " + computerScore);
    }
}
