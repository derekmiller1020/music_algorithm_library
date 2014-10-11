package com.dmill.Algorithms.Pads.Tools;

import java.util.ArrayList;
import java.util.List;


public class NotesParent {
    protected List<Integer> notes = new ArrayList<>();
    protected int numberOfOctaves;
    protected List<Integer> entityLength;

    protected Integer setUpLengths(int numberOfNotes, int index){
        if (entityLength.size() < numberOfNotes){
            while(entityLength.size() < numberOfNotes){
                entityLength.addAll(entityLength);
            }
        }

        return entityLength.get(index);
    }

    protected void checkNumberOfOctaves(){
        if (numberOfOctaves < 0 || numberOfOctaves > 2) {
            this.numberOfOctaves = 1;
        }
    }

    protected void setNotes(){
        for(int x = 1; x < 8 * numberOfOctaves; x++){
            notes.add(x);
        }
    }
}
