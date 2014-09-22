import com.dmill.Algorithms.Drums.BeatAlgorithms;

public class Main {

    public static void main(String args[]){

        try{
            BeatAlgorithms ba = new BeatAlgorithms.Builder()
                    .setMeasures(2)
                    .setRepeats(2)
                    .setNumberOfKicks(8)
                    .setNumberOfSnares(4)
                    .setTicksPerStaff(17)
                    .build("shuffle");
            ba.setUp();
            ba.execute();
            ba.toMidi();
        } catch (Exception e){
            System.out.println(e.toString());
        }


        /*
        SlowRoll slowRoll = new SlowRoll("c", -1, 2);
        slowRoll.setUp();
        slowRoll.toMidi();
        */

    }

}
