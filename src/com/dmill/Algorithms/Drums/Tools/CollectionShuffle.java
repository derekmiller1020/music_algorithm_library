package com.dmill.Algorithms.Drums.Tools;

import java.util.*;


public class CollectionShuffle {

    final private static String hit = "hit";
    final private static String space = "space";
    private int ticksPerStaff;
    private int drumBeats;

    public CollectionShuffle(int drumBeats, int ticksPerStaff){
        this.drumBeats = drumBeats;
        this.ticksPerStaff = ticksPerStaff;
    }

    public List<String> complete(int measures, int repeat){
        List<String> shuffleList = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < measures; i++){
            temp.addAll(shuffle(drumBeats, ticksPerStaff));
        }
        for (int x = -1; x < repeat; x++){
            shuffleList.addAll(temp);
        }
        return shuffleList;
    }

    public List<String> shuffle(int drumBeats, int ticksPerStaff){
        List<String> measure = new ArrayList<>();
        try{
            if (drumBeats > ticksPerStaff){
                drumBeats = ticksPerStaff;
            }

            measure = DrumUtilFunctions.addOrderedDrums(ticksPerStaff, drumBeats);
            Collections.shuffle(measure);

        } catch (Exception e){
            System.out.println(e.toString());
        }

        return measure;
    }

}
