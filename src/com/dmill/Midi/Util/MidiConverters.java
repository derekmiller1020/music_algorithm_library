package com.dmill.Midi.Util;

import com.dmill.Util.UtilityFunctions;

public class MidiConverters {

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

                pitch = 49;
                break;
            case "open-hat":
                pitch = 46;
                break;
            case "hi-tom":
                System.out.println("hit tom");
                pitch = 45;
                break;
            case "low-tom":
                pitch = 43;
                break;
            default:
                pitch = 1;
        }
        return pitch;
    }

    public static int convertTicksToMidi(int tick){
        int returnTick;
        int[] allowableTicks = {1, 2, 4, 6, 8, 10, 12, 16, 20, 24, 32};
        if (UtilityFunctions.arraySearch(allowableTicks, tick)){
            returnTick = 1920 / tick;
        } else {
            returnTick = 120;
        }

        return returnTick;
    }

    public static int convertNoteLengthToMidi(int note){
        return note * 120;
    }


}
