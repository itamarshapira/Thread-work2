package X_O;

import java.util.Random;

public class SelfPlayer extends Player
{
    SelfGame selfGame;

    public SelfPlayer(PlayerType playerType, SelfGame selfGame) {
        super(playerType);
        this.selfGame = selfGame;
    }

    @Override
    public void playTurn() {
        // Get an array of free cells on the game board
        Cell[] freeCells = selfGame.getFreeCells();

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

            selfGame.gameBoard[selectedCell.getRow()][selectedCell.getCol()] = currentPlayerSymbol;
        }
    }

    // Implement the run method as specified in the exercise
    @Override
    public void run()
    {
        selfGame.playGame();
    }

}
