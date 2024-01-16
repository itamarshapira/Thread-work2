package X_O;

enum PlayerType
{
    X,
    O
}
abstract class Game
{
    private PlayerType[][] gameBoard;

    public Game() {
        gameBoard = new PlayerType[5][5];
        // Initialize the game board
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gameBoard[i][j] = null;
            }
        }
    }

    public abstract void playGame();

    public void printBoard()
    {

    }

    public abstract PlayerType getTurn();

    //public abstract Cell[] getFreeCells();
}
