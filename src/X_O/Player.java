package X_O;

abstract class Player implements Runnable
{
  protected   PlayerType playerType;
    public Player(PlayerType playerType)
    {
        this.playerType = playerType;
    }

    public abstract void playTurn();
}
