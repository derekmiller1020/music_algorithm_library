import com.dmill.Algorithms.Drums.BeatAlgorithms;
import com.dmill.Algorithms.Pads.PadsAlgorithm;

public class Main {

    public static void main(String args[]){
        /*
        try{

            BeatAlgorithms ba = new BeatAlgorithms.Builder()
                    .setNumberOfKicks(45)
                    .setNumberOfSnares(25)
                    .setTicksPerStaff(64)
                    .setMeasures(1)
                    .setRepeats(1)
                    .build("shuffle");
            ba.execute();
        } catch (Exception e){
            System.out.println(e.toString());
        }
        */

        try{
            PadsAlgorithm pa = new PadsAlgorithm.Builder().build("slowroll");
            pa.execute();


        } catch (Exception e){
            System.out.println(e.toString());
        }

    }

}
