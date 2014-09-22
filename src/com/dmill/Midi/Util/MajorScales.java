package com.dmill.Midi.Util;


import java.util.List;

public class MajorScales {

    //simple facade patternish method
    public List<List<Integer>> chords(String key, int octave, List<List<Integer>> notes){
        int finalKey = convertKey(key);
        int finalOctave = octaveSetup(octave, finalKey);
        return convertChords(notes,finalOctave);
    }

    //todo add sharps
    public static int convertKey(String key){
        int returnKey;
        switch (key){
            case "a":
                returnKey = 69;
                break;
            case "b":
                returnKey = 71;
                break;
            case "c":
                returnKey = 60;
                break;
            case "d":
                returnKey = 62;
                break;
            case "e":
                returnKey = 64;
                break;
            case "f":
                returnKey = 65;
                break;
            case "g":
                returnKey = 67;
                break;
            default:
                returnKey = 60;
                break;
        }

        return returnKey;
    }

    public static int octaveSetup(int octave, int key){
        if (octave < -5 || octave > 5){
            octave = 0;
        }
        int tempOctave = octave * 12;
        return tempOctave + key;
    }

    public static List<List<Integer>> convertChords(List<List<Integer>> notes, int octaveKey){
        //outer loop
        for (List<Integer> note : notes){
            //inner loop
            for (int i = 0; i < note.size(); i++){
                note.set(i, majorKeySetup(note.get(i), octaveKey));
            }
        }
        return notes;
    }

    //algorithm is 0+2+2+1+2+2+2
    //todo refactor this
    public static int majorKeySetup(int note, int key){
        int majorNote = key;
        switch (note){
            case 1:
                majorNote = key;
                break;
            case 2:
                majorNote = key + 2;
                break;
            case 3:
                majorNote = key + 4;
                break;
            case 4:
                majorNote = key + 5;
                break;
            case 5:
                majorNote = key + 7;
                break;
            case 6:
                majorNote = key + 9;
                break;
            case 7:
                majorNote = key + 11;
                break;
            case 8:
                majorNote = key + 12;
                break;
            case 9:
                majorNote = key + 14;
                break;
            case 10:
                majorNote = key + 16;
                break;
            case 11:
                majorNote = key + 17;
                break;
            case 12:
                majorNote = key + 19;
                break;
            case 13:
                majorNote = key + 21;
                break;
            case 14:
                majorNote = key +23;
                break;


        }
        return majorNote;
    }


}