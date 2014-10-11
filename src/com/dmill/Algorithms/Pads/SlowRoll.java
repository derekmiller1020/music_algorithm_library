package com.dmill.Algorithms.Pads;

import com.dmill.Algorithms.Pads.Tools.SlowRollAlgorithm;


public class SlowRoll extends PadsAlgorithm{

    protected SlowRoll(Builder builder){
        super(builder);
        if (preset){
            usePreset();
        }
    }

    protected void usePreset(){
        if (chordLength.size() == 0){
            chordLength.add(16);
        }

        if (numberOfChords == 0){
            numberOfChords = 4;
        }
    }

    protected void setUp(){
        SlowRollAlgorithm slowRollAlgorithm = new SlowRollAlgorithm(numberOfOctaves, chordLength);
        fullChords = slowRollAlgorithm.chords(numberOfChords, repeats);
    }

    protected void toMidi(){
        String fileName = "slowRollAlgorithm_";
        super.toMidi(fileName);
    }

    public void execute(){
        setUp();
        toMidi();
    }
}
