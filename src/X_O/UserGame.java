package X_O;
// Itamar Shapira 315387902 & Ofir Roditi 208647297
/*
how to play specific user Game. cpu vs user.
 */

import java.util.Scanner;

public class UserGame extends Game
{
    private UserPlayer playerX;
    private UserPlayer playerO;

    public UserGame() {
        super();
        playerX = new UserPlayer(PlayerType.X, this); // Pass 'this' instead of 'UserGame'
        playerO = new UserPlayer(PlayerType.O, this); // Pass 'this' instead of 'UserGame'
    }
    @Override
    public void playGame()
    {
        // כל עוד המשחק ממשיך ניכנס ללולאה
        while (!isGameFinished()) {
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Get the current player's turn
            PlayerType currentPlayerTurn = getTurn();

            // Depending on the current player, play their turn
            if (currentPlayerTurn == PlayerType.X && !isBoardFull()) {
                playerX.playTurnOfUser();
            } else if (currentPlayerTurn == PlayerType.O && !isBoardFull()) {
                playerO.playTurn();
            }

            printBoard();
            System.out.println();

            // Check for a winner after each turn
            if (isGameWinner()) {
                System.out.println(currentPlayerTurn + " player wins!");
                break;  // Exit the loop if there's a winner
            }
        }

        // Game is finished, print the result
        if (isBoardFull() && !isGameWinner()) {
            System.out.println("The game is a draw.");
        }
    }

}
