package X_O;

public class SelfGame extends Game {

    private SelfPlayer playerX;
    private SelfPlayer playerO;

    public SelfGame()
    {
        super();
        playerX = new SelfPlayer(PlayerType.X);
        playerO = new SelfPlayer(PlayerType.O);
    }
    @Override
    public void playGame()
    {

    }

    @Override
    public PlayerType getTurn() {
        return null;
    }

//    @Override
//    public Cell[] getFreeCells() {
//        return new Cell[0];
//    }
}
