package com.dmill.Algorithms.Pads;

import com.dmill.Algorithms.Pads.Tools.Chords;
import com.dmill.Midi.MidiConverter;
import com.dmill.Util.Exceptions.PadException;
import com.dmill.Util.UtilityFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;


public abstract class PadsAlgorithm {

    protected String key;
    protected int keyOctave;
    protected int numberOfOctaves;
    protected int numberOfChords;
    protected List<Integer> chordLength;
    protected List<Chords> fullChords;
    protected int repeats;
    protected Boolean preset;

    protected PadsAlgorithm(Builder builder){
        key = builder.key;
        keyOctave = builder.keyOctave;
        this.numberOfChords = builder.numberOfChords;
        this.chordLength = builder.chordLength;
        this.repeats = builder.repeats;
        this.preset = builder.preset;
        this.numberOfOctaves = builder.numberOfOctaves;
    }

    protected void setUp(){
        //nothing yet
    }

    protected abstract void toMidi();

    protected void toMidi(String fileName){
        MidiConverter midiCoverter = new MidiConverter();
        System.out.println("This is key octave " + keyOctave);
        midiCoverter.convertChords(fullChords, key, keyOctave);
        String todaysDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
        fileName += todaysDate;
        midiCoverter.writeToMidi(fileName);
    }

    public abstract void execute();

    public static class Builder{
        private String key = "c";
        private int keyOctave = 0;
        private int numberOfOctaves = 1;
        private Boolean preset = true;
        private List<Integer> chordLength;
        private int numberOfChords = 0;
        private int repeats = 0;

        public Builder(){
            chordLength = new ArrayList<>();
        }

        public Builder setKey(String key) throws PadException {
            if (!UtilityFunctions.allowableKeys(key)){
                throw new PadException("You have entered an invalid key");
            } else {
                this.key = key;
            }
            return this;
        }

        public Builder setKeyOctave(int keyOctave) throws PadException{
            if (!UtilityFunctions.allowableOctaves(keyOctave)){
                throw new PadException("You have entered an invalid keyOctave");
            }
            this.keyOctave = keyOctave;
            return this;
        }

        public Builder setNumberOfOctaves(int numberOfOctaves){
            this.numberOfOctaves = numberOfOctaves;
            return this;
        }

        public Builder addNoteLength(int length) throws PadException{
            if (length < 0){
                throw new PadException("note length does not accept negative numbers");
            }
            this.chordLength.add(length);
            return this;
        }

        public Builder setNumberOfNotes(int numberOfChords){
            this.numberOfChords = numberOfChords;
            return this;
        }

        public Builder setRepeats(int repeats){
            this.repeats = repeats;
            return this;
        }

        public Builder setPreset(boolean preset){
            this.preset = preset;
            return this;
        }

        public PadsAlgorithm build(String algorithm) throws PadException{
            if (!UtilityFunctions.checkNumberOfOctaves(keyOctave, numberOfOctaves)){
                throw new PadException("You have entered an incorrect amount of octaves");
            }
            switch(algorithm){
                case "slowroll":
                    return new SlowRoll(this);
                default:
                    return null;
            }
        }
    }
}
