package com.dmill.Algorithms.Drums;

import com.dmill.Algorithms.Drums.Tools.DrumUtilFunctions;
import com.dmill.Midi.MidiConverter;
import com.dmill.Util.Exceptions.DrumException;
import com.dmill.Util.UtilityFunctions;

import java.util.*;


public abstract class BeatAlgorithms {
    //final drumset sent to midi
    protected Map<String, List> drumSet = new HashMap<>();
    //number of ticks wanted per staff
    protected int ticksPerStaff;
    //drum lists
    protected List<String> kick = new ArrayList<>();
    protected List<String> snare = new ArrayList<>();
    protected List<String> closedHat = new ArrayList<>();
    protected List<String> ride = new ArrayList<>();
    protected List<String> hiTom = new ArrayList<>();
    protected List<String> lowTom = new ArrayList<>();
    protected List<String> openHat = new ArrayList<>();
    //measures and repeating sets
    protected int measures;
    protected int repeats;
    //number of each drum wanted;
    protected int numberOfKicks;
    protected int numberOfSnares;
    protected int numberOfClosedHats;
    protected int numberOfRides;
    protected int numberOfHiToms;
    protected int numberOfLowToms;
    protected int numberOfOpenHats;
    protected Boolean preset;

    //set up all of the potential manual variables
    protected BeatAlgorithms(Builder builder){
        ticksPerStaff = builder.ticksPerStaff;
        numberOfKicks = builder.numberOfKicks;
        numberOfSnares = builder.numberOfSnares;
        numberOfClosedHats = builder.numberOfClosedHats;
        numberOfRides = builder.numberOfRides;
        numberOfHiToms = builder.numberOfHiToms;
        numberOfLowToms = builder.numberOfLowToms;
        numberOfOpenHats = builder.numberOfOpenHats;
        measures = builder.measures;
        repeats = builder.repeats;
        preset = builder.preset;

    }

    protected abstract void usePreset();

    //each drum algorithm needs a setUp
    protected abstract void setUp();

    protected abstract void addToSet();

    //and it needs and execute
    public abstract void execute();

    //method used for all sub classes that ensures the drum set is clear
    protected void clearDrumSet(){
        if (!drumSet.isEmpty()){
            drumSet.clear();
        }
    }

    //each class needs to implement the toMidi method
    protected abstract void toMidi();

    //this is used by the child class
    protected void toMidi(String fileName){
        MidiConverter midiCoverter = new MidiConverter();
        midiCoverter.convertBeats(drumSet, ticksPerStaff);
        midiCoverter.writeToMidi(fileName);
    }

    //builder static class to set drum hits dynamically
    public static class Builder {

        private int numberOfKicks = 0;
        private int numberOfSnares = 0;
        private int numberOfClosedHats = 0;
        private int numberOfRides = 0;
        private int numberOfHiToms = 0;
        private int numberOfLowToms = 0;
        private int numberOfOpenHats = 0;
        private int ticksPerStaff = 16;
        private int measures = 1;
        private int repeats = 0;
        private boolean preset = true;

        public Builder setNumberOfKicks(int numberOfKicks){
            this.numberOfKicks = numberOfKicks;
            return this;
        }

        public Builder setNumberOfSnares(int numberOfSnares){
            this.numberOfSnares = numberOfSnares;
            return this;
        }

        public Builder setNumberOfClosedHats(int numberOfClosedHats){
            this.numberOfClosedHats = numberOfClosedHats;
            return this;
        }

        public Builder setNumberOfRides(int numberOfRides){
            this.numberOfRides = numberOfRides;
            return this;
        }

        public Builder setNumberOfHiToms(int numberOfHiToms){
            this.numberOfHiToms = numberOfHiToms;
            return this;
        }

        public Builder setNumberOfLowToms(int numberOfLowToms){
            this.numberOfLowToms = numberOfLowToms;
            return this;
        }

        public Builder setNumberOfOpenHats(int numberOfOpenHats){
            this.numberOfOpenHats = numberOfOpenHats;
            return this;
        }

        public Builder setTicksPerStaff(int ticksPerStaff) throws DrumException{
            int[] allowableTicks = {1, 2, 4, 6, 8, 10, 12, 16, 20, 24, 32, 64};
            if (!UtilityFunctions.arraySearch(allowableTicks, ticksPerStaff)){
                throw new DrumException("You have entered an incorrect tick amount");
            }
            this.ticksPerStaff = ticksPerStaff;
            return this;
        }

        public Builder setMeasures(int measures){
            this.measures = measures;
            return this;
        }

        public Builder setRepeats(int repeats){
            this.repeats = repeats;
            return this;
        }

        public Builder setPreset(Boolean preset) {
            this.preset = preset;
            return this;
        }

        //factory pattern inside of the builder
        public BeatAlgorithms build(String algorithm) throws DrumException{

            int[] drums = new int[]{
                    numberOfKicks, numberOfSnares, numberOfClosedHats, numberOfHiToms, numberOfLowToms, numberOfRides,
                    numberOfOpenHats
            };

            //make sure some goon didn't try to throw in more beats than ticks per staff
            if (!DrumUtilFunctions.tickCatcher(ticksPerStaff, drums)){
               throw new DrumException("You cannot have more ticks per staff than drum beats");
            } else {

                switch (algorithm){
                    case "shuffle":
                        return new ShuffleAlgorithm(this);
                    case "blex":
                        return new BlexAlgorithm(this);
                    case "tres":
                        return new TresAlgorithm(this);
                    default:
                        return null;
                }
            }

        }
    }
}
