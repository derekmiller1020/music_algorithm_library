package com.dmill.Algorithms;

import com.dmill.Midi.DrumToMidiConverter;
import com.dmill.Util.UtilityFunctions;

import java.util.*;


public abstract class BeatAlgorithms {

    protected Map<String, List> drumSet = new HashMap<>();
    protected int ticksPerStaff;
    protected List<String> kick = new ArrayList<>();
    protected List<String> snare = new ArrayList<>();
    protected List<String> closedHat = new ArrayList<>();
    protected List<String> ride = new ArrayList<>();

    //sets a default of 16
    public BeatAlgorithms(){
        this.ticksPerStaff = 16;
    }

    public BeatAlgorithms(int ticksPerStaff){
        this.ticksPerStaff = UtilityFunctions.allowAbleTicks(ticksPerStaff);
    }

    public abstract void execute();

    public void toMidi(String fileName){
        DrumToMidiConverter midiCoverter = new DrumToMidiConverter();
        midiCoverter.convertBeats(drumSet, ticksPerStaff);
        midiCoverter.writeToMidi(fileName);
    }
}
