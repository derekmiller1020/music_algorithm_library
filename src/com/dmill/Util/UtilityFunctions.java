package com.dmill.Util;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UtilityFunctions {

    public static int allowAbleTicks(int tick){
        int returnTick;
        int[] allowableTicks = {1, 2, 4, 6, 8, 10, 12, 16, 20, 24, 32, 64};
        if (arraySearch(allowableTicks, tick)){
            returnTick = tick;
        } else {
            returnTick = 16;
        }

        return returnTick;
    }

    public static boolean arraySearch(int[] searchableArray, int number){
        for (int num : searchableArray){
            if (num == number){
                return true;
            }
        }
        return false;
    }

    public static boolean allowableKeys(String key){
        String[] keys = new String[]{"a", "b", "c", "d", "e", "f", "g", "g#"};
        for (String allowableKey : keys){
            if (allowableKey.equals(key)){
                return true;
            }
        }
        return false;
    }

    public static boolean allowableOctaves(int octave){
        if (octave > 5 || octave < -5){
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkNumberOfOctaves(int octave, int numberOfOctaves){
        if ( numberOfOctaves < 0 || numberOfOctaves + octave > 5){
            return false;
        } else {
            return true;
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


}
