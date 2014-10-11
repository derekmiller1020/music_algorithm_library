package com.dmill.Algorithms.Drums;

import com.dmill.Algorithms.Drums.Tools.Blex;
import com.dmill.Algorithms.Drums.Tools.CollectionShuffle;

import java.text.SimpleDateFormat;
import java.util.Date;


public class BlexAlgorithm extends BeatAlgorithms {

    protected BlexAlgorithm(Builder builder){
        super(builder);

        if (preset){
            usePreset();
        }
    }

    protected void usePreset(){
        if (numberOfKicks == 0){
            numberOfKicks = (int)Math.ceil(ticksPerStaff / 3);
        }

        if(numberOfSnares == 0){
            numberOfSnares = (int)Math.ceil(ticksPerStaff / 4);
        }

        if (numberOfClosedHats == 0){
            numberOfClosedHats = ticksPerStaff;
        }

        if (numberOfHiToms == 0){
            numberOfHiToms = (int)Math.ceil(ticksPerStaff / 8);
        }
    }

    protected void setUp(){
        super.clearDrumSet();

        kick.addAll(new CollectionShuffle(numberOfKicks, ticksPerStaff).complete(measures, repeats));
        snare.addAll(new Blex(numberOfSnares, kick, ticksPerStaff).complete(measures, repeats));
        closedHat.addAll(new CollectionShuffle(numberOfClosedHats, ticksPerStaff).complete(measures, repeats));
        hiTom.addAll(new Blex(numberOfHiToms, snare, ticksPerStaff).complete(measures, repeats));
    }

    protected void addToSet(){
        drumSet.put("kick", kick);
        drumSet.put("snare", snare);
        drumSet.put("closed-hat", closedHat);
        drumSet.put("hi-tom", hiTom);
        System.out.println(drumSet);
    }

    protected void toMidi(){
        String todaysDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
        String fileName = "blexAlgorithm_" + todaysDate;
        super.toMidi(fileName);
    }

    //facade pattern for end user
    public void execute(){
        setUp();
        addToSet();
        toMidi();
    }
}
