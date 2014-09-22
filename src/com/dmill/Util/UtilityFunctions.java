package com.dmill.Util;



public class UtilityFunctions {

    public static int allowAbleTicks(int tick){
        int returnTick;
        int[] allowableTicks = {1, 2, 4, 6, 8, 10, 12, 16, 20, 24, 32};
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

    public static boolean tickCatcher(int ticksPerStaff, int[]drumBeats){
        for (int drum : drumBeats){
            if (drum > ticksPerStaff){
                return false;
            }
        }
        return true;
    }

    public static boolean allowableKeys(String key){
        String[] keys = new String[]{"a", "b", "c", "d", "e", "f", "g"};
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
}
