package X_O;

abstract class Player implements Runnable
{
    PlayerType playerType;


    public Player(PlayerType playerType)
    {
        this.playerType = playerType;
    }
}
