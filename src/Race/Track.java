package Race;

public class Track
{
    private int finishedRacers=0;
//    public Track(int id, int meter)
//    {
//        finishedRacers++;
//        System.out.println("Runner: "+id+"finish the race: "+meter+"in the: "+finishedRacers+"st");
//    }

    public Track(){};

    public synchronized  void printFinishedRacers(int id, int meter)
    {
        finishedRacers++;
        String place="";
        if (finishedRacers==1)
            place="st";
        else if (finishedRacers==2)
            place="nd";
        else if (finishedRacers==3)
            place="rd";
        else place="th";


        System.out.println("Runner: "+id+" finish at the: "+finishedRacers+place);
    }
}
