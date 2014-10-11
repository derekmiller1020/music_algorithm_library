package com.dmill.Algorithms.Pads.Tools;


import com.dmill.Algorithms.Pads.Tools.NotesParent;
import com.dmill.Algorithms.Riff.Tools.Notes;
import com.dmill.Util.UtilityFunctions;

import java.util.ArrayList;
import java.util.List;

public class GenericAlgo extends NotesParent {

    public GenericAlgo(int numberOfOctaves, List<Integer> noteLengths){
        this.numberOfOctaves = numberOfOctaves;
        this.entityLength = noteLengths;
        super.setNotes();
    }

    public List<Chords> notes(int numberOfNotes, int repeats){
        super.checkNumberOfOctaves();
        List<Chords> fullNotes = new ArrayList<>();
        List<Chords> temp = new ArrayList<>();

        for (int i = 0; i < numberOfNotes; i++){
            Chords chords = new Chords();
            chords.setChord(setUpNotes());
            chords.setChordLength(setUpLengths(numberOfNotes, i));
            temp.add(chords);
        }

        for (int x = 0; x <= repeats; x++) {
            fullNotes.addAll(temp);
        }

        return fullNotes;
    }

    private List<Integer> setUpNotes(){
        List<Integer> singleNote = new ArrayList<>();

        UtilityFunctions.shuffleArray(notes);
        singleNote.add(notes.get(2));


        return singleNote;

    }


}
