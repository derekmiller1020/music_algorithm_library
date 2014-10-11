package com.dmill.Algorithms.Pads.Tools;

import java.util.*;

public class Chords {

    private int chordLength;
    private List<Integer> chord;


    public void setChordLength(int chordLength) {
        this.chordLength = chordLength;
    }
    public int getChordLength(){
        return chordLength;
    }

    public void setChord(List<Integer> chord){
        this.chord = chord;
    }
    public List<Integer> getChord(){
        return chord;
    }
}
