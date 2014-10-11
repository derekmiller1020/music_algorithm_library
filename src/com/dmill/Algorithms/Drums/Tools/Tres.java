package com.dmill.Algorithms.Drums.Tools;

import com.dmill.Util.UtilityFunctions;

import java.util.*;

public class Tres {

    private int ticksPerStaff;
    private int beats;

    public Tres(int beats, int ticksPerStaff){
        this.ticksPerStaff = ticksPerStaff;
        this.beats = beats;
    }

    public List<String> complete(int measures, int repeats){
        List<String> completeDrums = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < measures; i++){
            temp.addAll(placeHits());
        }
        for (int i = -1; i < repeats; i++){
            completeDrums.addAll(temp);
        }
        return completeDrums;
    }

    public List<String> placeHits(){
        List<String> drumBeats = new ArrayList<>();
        drumBeats = DrumUtilFunctions.emptyDrums(ticksPerStaff);
        List<Integer> positions = shuffleTres(ticksPerStaff);
        for (int i = 0; i < beats; i++){
            drumBeats.set(positions.get(i), "hit");
        }

        return drumBeats;
    }

    public static List<Integer> shuffleTres(int ticksPerStaff){
        List<Integer> three = new ArrayList<>();
        for (int i = 0; i < ticksPerStaff; i++){
            if (i % 3 == 0){
                three.add(i);
            }
        }
        three = UtilityFunctions.shuffleArray(three);
        return three;
    }
}
