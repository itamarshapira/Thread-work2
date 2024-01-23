package X_O;
// Itamar Shapira 315387902 & Ofir Roditi 208647297
// Cell class to represent a cell on the board
class Cell {
    private int row;
    private int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Add getters and setters as needed
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
