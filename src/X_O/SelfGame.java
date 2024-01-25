package X_O;
// Itamar Shapira 315387902 & Ofir Roditi 208647297

/*
how to play specific Self Game. cpu vs cpu.
 */
public class SelfGame extends Game {

    private SelfPlayer playerX;
    private SelfPlayer playerO;

    public SelfGame()
    {
        super();
        playerX = new SelfPlayer(PlayerType.X, this);
        playerO = new SelfPlayer(PlayerType.O, this);
    }

    @Override
    public synchronized void playGame() {

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
                playerX.playTurn();
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
