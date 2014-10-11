import com.dmill.Algorithms.Drums.BeatAlgorithms;
import com.dmill.Algorithms.Pads.PadsAlgorithm;

import java.util.HashMap;

public class Main {

    public static void main(String args[]){
        /*
        try{
            BeatAlgorithms ba = new BeatAlgorithms.Builder()
                    .setNumberOfKicks(5)
                    .setNumberOfSnares(4)
                    .setTicksPerStaff(16)
                    .setMeasures(1)
                    .setRepeats(1)
                    .build("tres");
            ba.execute();
        } catch (Exception e){
            System.out.println(e.toString());
        }


        try{
            PadsAlgorithm pa = new PadsAlgorithm.Builder()
                    .setKey("g#")
                    .setKeyOctave(1)
                    .addNoteLength(4)
                    .setNumberOfNotes(4)
                    .setRepeats(2)
                    .setNumberOfOctaves(2)
                    .build("slowroll")
                    ;
            pa.execute();
            new HashMap<>();


        } catch (Exception e){
            System.out.println(e.toString());
        }
        */

        try{
            PadsAlgorithm pa = new PadsAlgorithm.Builder()
                    .setKey("g#")
                    .setKeyOctave(0)
                    .addNoteLength(1)
                    .addNoteLength(1)
                    .addNoteLength(1)
                    .addNoteLength(1)
                    .addNoteLength(12)
                    .setNumberOfNotes(20)
                    .setRepeats(2)
                    .build("generic");
            pa.execute();
        } catch (Exception e){
            System.out.println(e.toString());
        }

    }

}
