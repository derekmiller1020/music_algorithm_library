package com.dmill.Algorithms.Drums;

import com.dmill.Algorithms.Drums.Tools.CollectionShuffle;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    Simple Algorithm that only uses kick, snare, and closed high-hat. It uses the Java Collections shuffle algorithm.
 */
public class ShuffleAlgorithm extends BeatAlgorithms {

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
    protected void setUp(){
        super.clearDrumSet();

        //add the arraylist to each drum - drumShuffle takes 4 arguments
        kick.addAll(new CollectionShuffle(numberOfKicks, ticksPerStaff).complete(measures, repeats));
        snare.addAll(new CollectionShuffle(numberOfSnares, ticksPerStaff).complete(measures, repeats));
        closedHat.addAll(new CollectionShuffle(numberOfClosedHats, ticksPerStaff).complete(measures, repeats));
    }

    protected void addToSet(){
        drumSet.put("kick", kick);
        drumSet.put("snare", snare);
        drumSet.put("closed-hat", closedHat);
    }

    //export the bad boy to midi
    protected void toMidi(){
        String todaysDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
        String fileName = "shuffleAlgorithm_" + todaysDate;
        super.toMidi(fileName);
    }

    //facade pattern for end user
    public void execute(){
        setUp();
        addToSet();
        toMidi();
    }

}
