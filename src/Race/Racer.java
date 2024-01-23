package Race;
// Itamar Shapira 315387902 & Ofir Roditi 208647297
import Race.Track;

public class Racer implements Runnable
{
private static int globalId=1;
private int id;
private int speed;

private int meters;

private Track track;

public Racer(int speed, Track track)
{
    setSpeed(speed);
    this.track=track;
    id=globalId;
    globalId++;
}

    @Override
    public void run()
    {
        go();
    }

    public void go()
    {
        Thread.currentThread().setPriority(speed);
        for(int i=0;i<=100;i++)
        {

           meters+=i;

            if  (meters>=100) {
                System.out.println("Id : "+id+ " ran: "+100+" meters");

                track.printFinishedRacers(id, meters);
                break;
            }
            else System.out.println("Id : "+id+ " ran: "+meters+" meters");
        }


    }
    public void setSpeed(int speed)
    {
        try {
            if (speed<1 || speed>10)
                throw new IllegalArgumentException("speed must be between 10 and 1");
            this.speed = speed;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public int getId() {
        return id;
    }
}
