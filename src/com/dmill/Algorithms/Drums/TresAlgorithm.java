package com.dmill.Algorithms.Drums;


import com.dmill.Algorithms.Drums.Tools.Blex;
import com.dmill.Algorithms.Drums.Tools.CollectionShuffle;
import com.dmill.Algorithms.Drums.Tools.Tres;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TresAlgorithm extends BeatAlgorithms {

    protected TresAlgorithm(Builder builder){
        super(builder);
        //this class has to use a preset
        usePreset();
    }


    protected void usePreset(){
        if (numberOfKicks == 0){
            numberOfKicks = (int)Math.ceil(ticksPerStaff / 3);
        }

        if (numberOfSnares == 0 || numberOfSnares > ticksPerStaff / 3){
            numberOfSnares = (int)Math.floor(ticksPerStaff / 3);
        }

        if (numberOfRides == 0){
            numberOfClosedHats = ticksPerStaff;
        }

        if (numberOfLowToms == 0 || numberOfLowToms > ticksPerStaff / 3){
            numberOfLowToms = (int)Math.ceil(ticksPerStaff / 6);
        }
    }

    protected void setUp(){
        super.clearDrumSet();

        snare.addAll(new Tres(numberOfSnares, ticksPerStaff).complete(measures, repeats));
        kick.addAll(new Blex(numberOfKicks, snare, ticksPerStaff).complete(measures, repeats));
        ride.addAll(new CollectionShuffle(numberOfClosedHats, ticksPerStaff).complete(measures, repeats));
        lowTom.addAll(new Tres(numberOfLowToms, ticksPerStaff).complete(measures, repeats));
    }

    protected void addToSet(){
        drumSet.put("kick", kick);
        drumSet.put("snare", snare);
        drumSet.put("ride", ride);
        drumSet.put("low-tom", lowTom);
        System.out.println(drumSet);
    }

    protected void toMidi(){
        String todaysDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
        String fileName = "TresAlgorithm_" + todaysDate;
        super.toMidi(fileName);
    }

    //facade pattern for end user
    public void execute(){
        setUp();
        addToSet();
        toMidi();
    }
}
