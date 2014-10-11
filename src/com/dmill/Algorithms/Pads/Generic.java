package com.dmill.Algorithms.Pads;


import com.dmill.Algorithms.Pads.Tools.GenericAlgo;
import com.dmill.Algorithms.Riff.RiffAlgorithm;

public class Generic extends PadsAlgorithm {

    protected Generic(Builder builder){
        super(builder);
        if (preset){
            usePreset();
        }
    }

    public void execute(){
        setUp();
        toMidi();
    }

    protected void usePreset(){
        if (chordLength.size() == 0){
            chordLength.add(4);
        }
    }

    protected void setUp(){
        GenericAlgo genericAlgo = new GenericAlgo(numberOfOctaves, chordLength);
        fullChords = genericAlgo.notes(numberOfChords, repeats);
    }

    protected void toMidi(){
        String fileName = "genericAlgorithm_";
        super.toMidi(fileName);
    }
}
