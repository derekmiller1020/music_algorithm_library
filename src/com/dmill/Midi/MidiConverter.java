package com.dmill.Midi;

import com.dmill.Midi.Util.MajorScales;
import com.dmill.Midi.Util.MidiConverters;
import com.leff.midi.MidiFile;
import com.leff.midi.MidiTrack;
import com.leff.midi.event.meta.TimeSignature;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class MidiConverter {

    // 1. Create some MidiTracks
    private ArrayList<MidiTrack> tracks = new ArrayList<>();
    private MidiTrack noteTrack = new MidiTrack();
    private MidiTrack tempoTrack = new MidiTrack();

    public MidiConverter() {

        TimeSignature timeSignature = new TimeSignature();
        //these are more todos
        //default_meter = 24, default division = 8. This is static for now.
        timeSignature.setTimeSignature(4, 4, TimeSignature.DEFAULT_METER, TimeSignature.DEFAULT_DIVISION);
        //insert time signature
        tempoTrack.insertEvent(timeSignature);
    }

    public void convertBeats(Map<String, List> drumBeats, int tickAmount) {

        int pitch;
        int tick = MidiConverters.convertTicksToMidi(tickAmount);
        //set up the channel stuff
        int channel = 0, velocity = 100;

        //outer loop
        for (Map.Entry<String, List> individualDrum : drumBeats.entrySet()) {
            pitch = MidiConverters.convertStringToMidi(individualDrum.getKey());
            String key = individualDrum.getKey();

            //inner loop to convert the beats
            for (int i = 0; i < drumBeats.get(key).size(); i++) {
                //if the list contains a hit, the add the note
                if (drumBeats.get(key).get(i).equals("hit")) {
                    noteTrack.insertNote(channel, pitch, velocity, i*tick, tick);
                }
            }
        }
    }

    public void convertChords(List<List<Integer>> fullChords, String key, int octave){
        int pitch;
        int tick = MidiConverters.convertTicksToMidi(1) * 2;
        int channel = 0, velocity = 100;
        fullChords = new MajorScales().chords(key, octave, fullChords);
        System.out.println(fullChords);

        //outer loop
        for(int i = 0; i < fullChords.size(); i++){
            //inner loop
            for (int x = 0; x < fullChords.get(i).size(); x++){
                pitch = fullChords.get(i).get(x);
                try{
                    noteTrack.insertNote(channel, pitch, velocity, i*tick, tick);
                    System.out.println(pitch + " " + tick + " " + i*tick);
                } catch (Exception e){
                    System.out.println(e.toString());
                }

            }
        }
    }

    //writes to the midi file
    public void writeToMidi(String fileName){
        System.out.println(noteTrack.getSize());
        //add the track
        tracks.add(noteTrack);
        //add the tempo track
        tracks.add(tempoTrack);

        //set up midi file. Default resolution = 480;
        MidiFile midi = new MidiFile(MidiFile.DEFAULT_RESOLUTION, tracks);

        //Write the MIDI data to a file
        File output = new File(fileName + ".mid");
        try {
            midi.writeToFile(output);
        } catch(IOException e) {
            System.err.println(e.toString());
        }
    }
}
