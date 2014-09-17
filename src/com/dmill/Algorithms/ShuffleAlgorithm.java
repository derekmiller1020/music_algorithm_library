package com.dmill.Algorithms;

import com.dmill.Algorithms.Util.CollectionShuffle;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ShuffleAlgorithm extends BeatAlgorithms {

    private CollectionShuffle collectionShuffle = new CollectionShuffle();
    private int numberOfKicks = 10;
    private int numberOfSnares = 4;
    private int numberOfClosedHats = 16;

    public ShuffleAlgorithm(){
        super();
    }

    public ShuffleAlgorithm(int ticksPerStaff){
        super(ticksPerStaff);
    }

    public void setUpShuffle(){
        if (!drumSet.isEmpty()){
            drumSet.clear();
        }
        kick.addAll(collectionShuffle.drumShuffle(numberOfKicks, ticksPerStaff));
        snare.addAll(collectionShuffle.drumShuffle(numberOfSnares, ticksPerStaff));
        closedHat.addAll(collectionShuffle.drumShuffle(numberOfClosedHats, ticksPerStaff));
    }

    public void setUpShuffle(int measures){
        if (!drumSet.isEmpty()){
            drumSet.clear();
        }
        kick.addAll(collectionShuffle.drumShuffle(10, ticksPerStaff, measures));
        snare.addAll(collectionShuffle.drumShuffle(4, ticksPerStaff, measures));
        closedHat.addAll(collectionShuffle.drumShuffle(16, ticksPerStaff, measures));
    }

    public void setUpShuffle(int measures, int repeats){
        if (!drumSet.isEmpty()){
            drumSet.clear();
        }
        kick.addAll(collectionShuffle.drumShuffle(numberOfKicks, ticksPerStaff, measures, repeats));
        snare.addAll(collectionShuffle.drumShuffle(numberOfSnares, ticksPerStaff, measures, repeats));
        closedHat.addAll(collectionShuffle.drumShuffle(numberOfClosedHats, ticksPerStaff, measures, repeats));
    }

    public void execute(){
        drumSet.put("kick", kick);
        drumSet.put("snare", snare);
        drumSet.put("closed-hat", closedHat);
    }

    public void toMidi(){
        String todaysDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
        String fileName = "shuffleAlgorithm_" + todaysDate;
        super.toMidi(fileName);
    }

    public void setDrumNumbers(int numberOfKicks, int numberOfSnares, int numberOfClosedHats){
        this.numberOfKicks = numberOfKicks;
        this.numberOfSnares = numberOfSnares;
        this.numberOfClosedHats = numberOfClosedHats;
    }

    public void setNumberOfKicks(int numberOfKicks){
        this.numberOfKicks = numberOfKicks;
    }

    public void setNumberOfSnares(int numberOfSnares){
        this.numberOfSnares = numberOfSnares;
    }

    public void setNumberOfClosedHats(int numberOfClosedHats){
        this.numberOfClosedHats = numberOfClosedHats;
    }
}
