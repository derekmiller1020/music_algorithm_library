package com.dmill.Util;

public class UtilityFunctions {

    public static int convertStringToMidi(String beat){
        int pitch = 1;
        String key = "other";

        switch (beat){
            case "kick":
                pitch = 36;
                break;
            case "snare":
                System.out.println("Hit snare");
                pitch = 40;
                break;
            case "closed-hat":
                pitch = 42;
                break;
            case "ride":
                System.out.println("hit ride");
                pitch = 49;
                break;
            default:
                pitch = 1;
        }
        return pitch;
    }

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

    public static int convertTicksToMidi(int tick){
        int returnTick;
        int[] allowableTicks = {1, 2, 4, 6, 8, 10, 12, 16, 20, 24, 32};
        if (arraySearch(allowableTicks, tick)){
            returnTick = 1920 / tick;
        } else {
            returnTick = 120;
        }

        return returnTick;
    }

    public static boolean arraySearch(int[] searchableArray, int number){
        for (int num : searchableArray){
            if (num == number){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
