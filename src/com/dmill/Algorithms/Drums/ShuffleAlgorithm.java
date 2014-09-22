package com.dmill.Algorithms.Drums;

import com.dmill.Algorithms.Drums.BeatAlgorithms;
import com.dmill.Algorithms.Util.CollectionShuffle;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    Simple Algorithm that only uses kick, snare, and closed high-hat. It uses the Java Collections shuffle algorithm.
 */
public class ShuffleAlgorithm extends BeatAlgorithms {

    //Utility algorithm used for shuffling - used for this class
    private CollectionShuffle collectionShuffle = new CollectionShuffle();

    //calls parent class and by default uses 16 ticks, if the user has not specified how many ticks per staff they want
    protected ShuffleAlgorithm(Builder builder){
        super(builder);

        if (preset){
            usePreset();
        }
    }

    protected void usePreset(){
        if (numberOfKicks == 0){
            numberOfKicks = (int)Math.ceil(ticksPerStaff / 2);
        }

        if(numberOfSnares == 0){
            numberOfSnares = (int)Math.ceil(ticksPerStaff / 4);
        }

        if (numberOfClosedHats == 0){
            numberOfClosedHats = ticksPerStaff;
        }
    }

    //this setup function gives the user the ability to have as many measures as they want, plus the amount of repeats
    public void setUp(){
        super.clearDrumSet();

        //add the arraylist to each drum - drumShuffle takes 4 arguments
        kick.addAll(collectionShuffle.drumShuffle(numberOfKicks, ticksPerStaff, measures, repeats));
        snare.addAll(collectionShuffle.drumShuffle(numberOfSnares, ticksPerStaff, measures, repeats));
        closedHat.addAll(collectionShuffle.drumShuffle(numberOfClosedHats, ticksPerStaff, measures, repeats));
    }

    //take the set up drums and complete the drumset
    public void execute(){
        drumSet.put("kick", kick);
        drumSet.put("snare", snare);
        drumSet.put("closed-hat", closedHat);
    }

    //export the bad boy to midi
    public void toMidi(){
        String todaysDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
        String fileName = "shuffleAlgorithm_" + todaysDate;
        super.toMidi(fileName);
    }

}
