import com.dmill.Algorithms.BeatAlgorithms;
import com.dmill.Algorithms.ShuffleAlgorithm;

public class Main {

    public static void main(String args[]){
        ShuffleAlgorithm shuffleAlgorithm = new ShuffleAlgorithm();
        shuffleAlgorithm.setUpShuffle();
        shuffleAlgorithm.toMidi();
    }
}
