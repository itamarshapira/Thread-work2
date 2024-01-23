package X_O;

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
    public void playTurnOfUser()
    {
        Scanner sc = new Scanner(System.in);
            // Randomly select a free cell from the available options
            System.out.println("Enter row");
            int row = sc.nextInt();
            System.out.println("Enter col");
            int col = sc.nextInt();

            // Mark the selected cell with the current player's symbol (X or O)
            char currentPlayerSymbol;
            if (playerType == PlayerType.X) {
                currentPlayerSymbol = 'X';
            } else {
                currentPlayerSymbol = 'O';
            }
            userGame.gameBoard[row][col] = currentPlayerSymbol;
        }

    @Override
    public void run() {
        userGame.playGame();
    }
}
