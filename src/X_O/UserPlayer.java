package X_O;
// Itamar Shapira 315387902 & Ofir Roditi 208647297
/*
user player make the logic of what a user player and a self player in the game need to do.
 */
import java.util.Random;
import java.util.Scanner;

public class UserPlayer extends Player {
    UserGame userGame;

    public UserPlayer(PlayerType playerType, UserGame userGame) {
        super(playerType);
        this.userGame = userGame;
    }

    @Override
    public void playTurn() {
        // Get an array of free cells on the game board
        Cell[] freeCells = userGame.getFreeCells();

        // Check if there are any free cells available
        if (freeCells.length > 0) {
            // Randomly select a free cell from the available options
            Random random = new Random();
            Cell selectedCell = freeCells[random.nextInt(freeCells.length)];

            // Mark the selected cell with the current player's symbol (X or O)
            char currentPlayerSymbol;
            if (playerType == PlayerType.X) {
                currentPlayerSymbol = 'X';
            } else {
                currentPlayerSymbol = 'O';
            }

            userGame.gameBoard[selectedCell.getRow()][selectedCell.getCol()] = currentPlayerSymbol;
        }
    }

    public void playTurnOfUser() {
        Scanner sc = new Scanner(System.in);
        // Randomly select a free cell from the available options

        int row = 0, col = 0;
        while (true) {
            System.out.println("Enter row");
            row = sc.nextInt();
            System.out.println("Enter col");
            col = sc.nextInt();

            if (userGame.gameBoard[row][col] != ' ') {
                System.out.println("The selected cell is already occupied. Try again.");
            }
            else
            {
                // Mark the selected cell with the current player's symbol (X or O)
                char currentPlayerSymbol;
                if (playerType == PlayerType.X) {
                    currentPlayerSymbol = 'X';
                } else {
                    currentPlayerSymbol = 'O';
                }
                userGame.gameBoard[row][col] = currentPlayerSymbol;
            }
            break;
        }
    }

    @Override
    public void run() {
        userGame.playGame();
    }
}
