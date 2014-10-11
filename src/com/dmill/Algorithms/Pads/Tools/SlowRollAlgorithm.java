package com.dmill.Algorithms.Pads.Tools;


import com.dmill.Util.UtilityFunctions;

import java.util.ArrayList;
import java.util.List;

public class SlowRollAlgorithm extends NotesParent{

    public SlowRollAlgorithm(int numberOfOctaves, List<Integer> entityLength){
        this.numberOfOctaves = numberOfOctaves;
        this.entityLength = entityLength;
        setNotes();
    }

    public List<Chords> chords(int numberOfChords, int repeats){
        checkNumberOfOctaves();
        List<Chords> fullChords = new ArrayList<>();
        List<Chords> temp = new ArrayList<>();

        for (int i = 0; i < numberOfChords; i++){
            Chords chord = new Chords();
            chord.setChord(setUpChord());
            chord.setChordLength(setUpLengths(numberOfChords, i));
            temp.add(chord);

        }

        for (int x = -1; x < repeats; x++) {
            fullChords.addAll(temp);
        }

        return fullChords;
    }

    private List<Integer> setUpChord(){
        List<Integer> singleChord = new ArrayList<>();

        UtilityFunctions.shuffleArray(notes);
        singleChord.add(notes.get(1));
        singleChord.add(notes.get(2));
        singleChord.add(notes.get(0));
        singleChord.add(notes.get(4));

        return singleChord;
        
    }

}
