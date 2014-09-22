package com.dmill.Algorithms.Util;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SlowRollAlgorithm {

    List<Integer> notes = new ArrayList<>();
    int numberOfOctaves = 1;

    public List<List<Integer>> chords(){

        setNotes();

        List<List<Integer>> fullChords = new ArrayList<>();
        List<Integer> chord1 = new ArrayList<>();
        List<Integer> chord2 = new ArrayList<>();
        List<Integer> chord3 = new ArrayList<>();
        List<Integer> chord4 = new ArrayList<>();

        shuffleArray(notes);
        chord1.add(notes.get(1));
        chord1.add(notes.get(2));
        chord1.add(notes.get(0));
        chord1.add(notes.get(4));

        shuffleArray(notes);
        chord2.add(notes.get(5));
        chord2.add(notes.get(4));
        chord2.add(notes.get(6));
        chord2.add(notes.get(3));

        shuffleArray(notes);
        chord3.add(notes.get(2));
        chord3.add(notes.get(1));
        chord3.add(notes.get(4));
        chord3.add(notes.get(0));

        shuffleArray(notes);
        chord4.add(notes.get(3));
        chord4.add(notes.get(2));
        chord4.add(notes.get(1));
        chord4.add(notes.get(5));

        fullChords.add(chord1);
        fullChords.add(chord2);
        fullChords.add(chord3);
        fullChords.add(chord4);

        return fullChords;
    }

    public void setNumberOfOctaves(int numberOfOctaves){
        if (numberOfOctaves > 0 && numberOfOctaves < 3) {
            this.numberOfOctaves = numberOfOctaves;
        }

    }

    // Implementing Fisher–Yates shuffle
    public static List<Integer> shuffleArray(List<Integer> notes)
    {
        Random random = new Random();
        for (int i = notes.size() - 1; i > 0; i--)
        {
            int index = random.nextInt(i + 1);
            // Simple swap
            int temp = notes.get(index);
            notes.set(index, notes.get(i));
            notes.set(i, temp);
        }
        return notes;
    }

    public void setNotes(){
        for(int x = 0; x < 7 * numberOfOctaves; x++){
            notes.add(x);
        }
    }
}
