package com.dmill.Algorithms.Pads;

import com.dmill.Algorithms.Pads.Tools.SlowRollAlgorithm;


public class SlowRoll extends PadsAlgorithm{

    protected SlowRoll(Builder builder){
        super(builder);
        if (preset){
            usePreset();
        }

        System.out.println("hit constructor");

    }

    protected void usePreset(){
        System.out.println("hits preset");
        if (chordLength.size() == 0){
            chordLength.add(4);
        }

        if (numberOfChords == 0){
            numberOfChords = 4;
        }
    }

    protected void setUp(){
        System.out.println("hits setup");
        SlowRollAlgorithm slowRollAlgorithm = new SlowRollAlgorithm(numberOfOctaves, chordLength);
        fullChords = slowRollAlgorithm.chords(numberOfChords, repeats);
    }

    protected void toMidi(){
        System.out.println("hits midi");
        String fileName = "slowRollAlgorithm_";
        super.toMidi(fileName);
    }

    public void execute(){
        setUp();
        toMidi();
    }
}
