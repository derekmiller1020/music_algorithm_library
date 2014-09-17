package com.dmill.Algorithms.Util;

import java.util.*;


public class CollectionShuffle {

    final private static String hit = "hit";
    final private static String space = "space";

    public List<String> drumShuffle(int drumBeats, int ticksPerStaff){
       return shuffle(drumBeats, ticksPerStaff);
    }

    public List<String> drumShuffle(int drumBeats, int ticksPerStaff, int measures){
        List<String> shuffleList = new ArrayList<>();
        for (int i = 0; i < measures; i++){
            shuffleList.addAll(shuffle(drumBeats, ticksPerStaff));
        }
        return shuffleList;
    }

    public List<String> drumShuffle(int drumBeats, int ticksPerstaff, int measures, int repeat){
        List<String> shuffleList = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < measures; i++){
            temp.addAll(shuffle(drumBeats, ticksPerstaff));
        }
        for (int x = 0; x < repeat; x++){
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
            int spaces = ticksPerStaff - drumBeats;
            for (int x = 0; x < ticksPerStaff; x++){
                if (x < spaces){
                    measure.add(space);
                }
                if (x >= spaces){
                    measure.add(hit);
                }
            }
            Collections.shuffle(measure);

        } catch (Exception e){
            System.out.println(e.toString());
        }

        return measure;
    }

}
