package com.dmill.Algorithms.Drums.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by derekmiller on 9/22/14.
 */
public class DrumUtilFunctions {

    public static List<String> addOrderedDrums(int ticksPerStaff, int numberOfDrums){
        List<String> drumList = new ArrayList<>();
        int spaces = ticksPerStaff - numberOfDrums;
        for (int x = 0; x < ticksPerStaff; x++){
            if (x < spaces){
                drumList.add("space");
            }
            if (x >= spaces){
                drumList.add("hit");
            }
        }
        return drumList;
    }

    public static List<String> emptyDrums(int ticksPerStaff){
        List<String> drumList = new ArrayList<>();
        for (int x = 0; x < ticksPerStaff; x++){
            drumList.add("space");
        }
        return drumList;
    }

    public static boolean tickCatcher(int ticksPerStaff, int[]drumBeats){
        for (int drum : drumBeats){
            if (drum > ticksPerStaff){
                return false;
            }
        }
        return true;
    }
}
