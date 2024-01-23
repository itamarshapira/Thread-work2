package X_O;
// Itamar Shapira 315387902 & Ofir Roditi 208647297
abstract class Player implements Runnable
{
  protected   PlayerType playerType;
    public Player(PlayerType playerType)
    {
        this.playerType = playerType;
    }

    public abstract void playTurn();
}
