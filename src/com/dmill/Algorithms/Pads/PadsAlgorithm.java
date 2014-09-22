package com.dmill.Algorithms.Pads;

import com.dmill.Midi.MidiConverter;
import com.dmill.Util.Exceptions.PadException;
import com.dmill.Util.UtilityFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by derekmiller on 9/21/14.
 */
public abstract class PadsAlgorithm {

    protected String key;
    protected int keyOctave;
    protected int numberOfOctaves;
    protected List<List<Integer>> fullChords;

    protected PadsAlgorithm(Builder builder){
        key = "c";
        keyOctave = 0;
    }

    public void setUp(){
        //nothing yet
    }

    public abstract void toMidi();

    public void toMidi(String fileName){
        MidiConverter midiCoverter = new MidiConverter();
        midiCoverter.convertChords(fullChords, key, keyOctave);
        String todaysDate = new SimpleDateFormat("ddMMyyyy").format(new Date());
        fileName += todaysDate;
        midiCoverter.writeToMidi(fileName);
    }

    public static class Builder{
        private String key = "c";
        private int keyOctave = 0;
        private int numberOfOctaves = 1;

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
            return this;
        }

        public Builder setNumberOfOctaves(int numberOfOctaves){
            this.numberOfOctaves = numberOfOctaves;
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
