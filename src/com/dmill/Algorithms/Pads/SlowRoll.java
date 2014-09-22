package com.dmill.Algorithms.Pads;


import com.dmill.Algorithms.Util.SlowRollAlgorithm;

public class SlowRoll extends PadsAlgorithm{

    SlowRollAlgorithm slowRollAlgorithm = new SlowRollAlgorithm();


    protected SlowRoll(Builder builder){
        super(builder);
    }

    public void setUp(){
        slowRollAlgorithm.setNumberOfOctaves(numberOfOctaves);
        fullChords = slowRollAlgorithm.chords();
    }

    public void toMidi(){
        String fileName = "slowRollAlgorithm_";
        super.toMidi(fileName);
    }
}
