package com.dmill.Algorithms.Pads.Tools;


import com.dmill.Algorithms.Pads.SlowRoll;
import com.dmill.Util.UtilityFunctions;

import java.util.ArrayList;
import java.util.List;

public class SlowRollAlgorithm {

    private List<Integer> notes = new ArrayList<>();
    private int numberOfOctaves;
    private List<Integer> chordLengths;

    public SlowRollAlgorithm(int numberOfOctaves, List<Integer> chordLengths){
        this.numberOfOctaves = numberOfOctaves;
        this.chordLengths = chordLengths;
        setNotes();
    }

    public List<Chords> chords(int numberOfChords, int repeats){
        checkNumberOfOctaves();
        System.out.println("passed octaves");
        List<Chords> fullChords = new ArrayList<>();
        List<Chords> temp = new ArrayList<>();

        for (int i = 0; i < numberOfChords; i++){
            Chords chord = new Chords();
            chord.setChord(setUpChord());
            chord.setChordLength(setUpLengths(numberOfChords, i));
            temp.add(chord);
            System.out.println(chord.getChord());
        }

        System.out.println("passed first chords loop");

        for (int x = -1; x < repeats; x++) {
            fullChords.addAll(temp);
        }

        System.out.println("passed second for loop");

        return fullChords;
    }

    private List<Integer> setUpChord(){
        List<Integer> singleChord = new ArrayList<>();

        UtilityFunctions.shuffleArray(notes);
        System.out.println(notes);
        singleChord.add(notes.get(1));
        singleChord.add(notes.get(2));
        singleChord.add(notes.get(0));
        singleChord.add(notes.get(4));

        System.out.println("finished setUp chord");
        return singleChord;
        
    }

    private Integer setUpLengths(int numberOfChords, int index){
        if (chordLengths.size() < numberOfChords){
            while(chordLengths.size() < numberOfChords){
                chordLengths.addAll(chordLengths);
            }
        }

        return chordLengths.get(index);
    }

    private void checkNumberOfOctaves(){
        if (numberOfOctaves < 0 || numberOfOctaves > 2) {
            this.numberOfOctaves = 1;
        }
    }

    private void setNotes(){
        System.out.println(numberOfOctaves);
        for(int x = 1; x < 8 * numberOfOctaves; x++){
            notes.add(x);
        }
        System.out.println(notes);
    }
}
