package X_O;
// Itamar Shapira 315387902 & Ofir Roditi 208647297
enum PlayerType
{
    X,
    O
}
 abstract class Game
{
    protected char[][] gameBoard;

    public Game() // cotr made new char[][] arr
    {
         gameBoard = new char[5][5];
        // Initialize the game board with empty spaces
        for (int i = 0; i < gameBoard.length; i++)
        {
            for (int j = 0; j < gameBoard[i].length; j++)
            {
                gameBoard[i][j] = ' ';
            }
        }
        // Initialize the game board
    }
    public abstract void playGame();
    public synchronized void printBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(gameBoard[i][j] + " | ");
            }
            System.out.println();
            if (i < 4) {
                System.out.println("--------------------");
            }
        }
        System.out.println();
    }
    protected PlayerType getTurn() {  //return the turn of the player by count the X and O of each player.
        int countX = 0;
        int countO = 0;

        // Count the number of X and O on the board
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == 'X') {
                    countX++;
                } else if (gameBoard[i][j] == 'O') {
                    countO++;
                }
            }
        }
        // Determine whose turn it is based on the counts
        if (countX <= countO) {
            return PlayerType.X;
        } else {
            return PlayerType.O;
        }
    }
    // Method to get a list of free cells on the board
    public Cell[] getFreeCells() {
        // Find and return the free cells
        int countFreeCells = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == ' ') {
                    countFreeCells++;
                }
            }
        }

        Cell[] freeCells = new Cell[countFreeCells];
        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == ' ') {
                    freeCells[index] = new Cell(i, j);
                    index++;
                }
            }
        }

        return freeCells;
    }
    // Check if the game is finished (either won or drawn)
    protected boolean isGameFinished()
    {
        return isGameWinner() || isBoardFull();
    }
    // Check if there is winner
    protected  boolean isGameWinner() {
        // Check rows
        for (int i = 0; i < 5; i++) {
            if (checkRow(i)==true) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 5; j++) {
            if (checkColumn(j)) {
                return true;
            }
        }

        // Check diagonals
        if (checkDiagonal() || checkAntiDiagonal()) {
            return true;
        }

        return false;
    }

    protected boolean checkRow(int row) {
        for (int j = 0; j <= 1; j++) {
            char currentCell = gameBoard[row][j];
            if (currentCell == ' ') {
                continue; // Skip empty cells
            }
            // Check the next three cells in the row
            for (int k = 1; k < 4; k++) {
                if (gameBoard[row][j + k] != currentCell) {
                    break; // Not four in a row
                }
                // Four in a row found
                if (k == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean checkColumn(int col) {
        for (int i = 0; i <= 1; i++) {
            char currentCell = gameBoard[i][col];
            if (currentCell == ' ') {
                continue; // Skip empty cells
            }

            // Check the next three cells in the column
            for (int k = 1; k < 4; k++) {
                if (gameBoard[i + k][col] != currentCell) {
                    break; // Not four in a row
                }

                // Four in a row found
                if (k == 3) {
                    return true;
                }
            }
        }

        return false;
    }

    protected boolean checkDiagonal() {
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                char currentCell = gameBoard[i][j];
                if (currentCell == ' ') {
                    continue; // Skip empty cells
                }

                // Check the next three cells in the diagonal
                for (int k = 1; k < 4; k++) {
                    if (gameBoard[i + k][j + k] != currentCell) {
                        break; // Not four in a row
                    }

                    // Four in a row found
                    if (k == 3) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    protected boolean checkAntiDiagonal() {
        for (int i = 0; i <= 1; i++) {
            for (int j = 4; j >= 3; j--) {
                char currentCell = gameBoard[i][j];
                if (currentCell == ' ') {
                    continue; // Skip empty cells
                }

                // Check the next three cells in the anti-diagonal
                for (int k = 1; k < 4; k++) {
                    if (gameBoard[i + k][j - k] != currentCell) {
                        break; // Not four in a row
                    }

                    // Four in a row found
                    if (k == 3) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Check if the board is full
    protected boolean isBoardFull() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        System.out.println("Board is full.");
        return true;
    }
}

