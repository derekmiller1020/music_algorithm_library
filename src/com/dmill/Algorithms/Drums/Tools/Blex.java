package com.dmill.Algorithms.Drums.Tools;

import com.dmill.Util.UtilityFunctions;
import java.util.*;


public class Blex {

    int oddHitCount = 0;
    int evenHitCount = 0;
    List<String> drumPattern;
    int numberOfDrums;
    int ticksPerStaff;

    public Blex(int numberOfDrums, List<String> drumPattern, int ticksPerStaff){
        this.numberOfDrums = numberOfDrums;
        this.drumPattern = drumPattern;
        this.ticksPerStaff = ticksPerStaff;
    }

    //another facade-ish pattern
    public List<String> complete(int measures, int repeats){
        List<String> beatList = new ArrayList<>();
        //sets the hitCounts
        setHitCounts();

        //double check that some tom-foolery isn't happening with ticks per staff by the end user
        if (numberOfDrums > ticksPerStaff){
            numberOfDrums = ticksPerStaff;
        }

        List<String> temp = new ArrayList<>();
        for (int i = 0; i < measures; i++){
            temp.addAll(oddOrEven());
        }
        for (int x = -1; x < repeats; x++){
            beatList.addAll(temp);
        }
        return beatList;
    }

    public void setHitCounts(){
        for (int x = 0; x < drumPattern.size(); x++){
            if (x % 2 == 0 && drumPattern.get(x).equals("hit")){
                evenHitCount++;
            }
            if (x % 2 != 0 && drumPattern.get(x).equals("hit")){
                oddHitCount++;
            }
        }
    }

    public List<String> oddOrEven(){
        List<String> beatList = new ArrayList<>();
        //create an empty drum list
        beatList = DrumUtilFunctions.emptyDrums(ticksPerStaff);
        //this algorithm doesn't accept more beats - it doesn't really make sense
        if (numberOfDrums > ticksPerStaff / 2){
            numberOfDrums = (int)Math.floor(ticksPerStaff / 2);
        }

        //if there are more odd than even
        if (oddHitCount > evenHitCount){
            //assign itself back to the shuffle evens method
            beatList = shuffleEvens(ticksPerStaff, numberOfDrums, beatList);
        } else if (evenHitCount > oddHitCount){
            beatList = shuffleOdds(ticksPerStaff, numberOfDrums, beatList);
        } else {
            Random random = new Random();
            int number = random.nextInt(10);
            if (number % 2 == 0){
                beatList = shuffleEvens(ticksPerStaff, numberOfDrums, beatList);
            } else {
                beatList = shuffleOdds(ticksPerStaff, numberOfDrums, beatList);
            }

        }
        return beatList;
    }

    // todo remove this and put it in a different algorithm
    public static List<String> shuffleBlex(List<String> hits, boolean even)
    {
        Random random = new Random();
        for (int i = hits.size() - 1; i > 0; i--)
        {
            int index = random.nextInt(i + 1);
            // Simple swap
            if (even){
                if (index % 2 != 0 && index != 0){
                    index = index - 1;
                }
            } else {
                if (index % 2 == 0 && index != 0){
                    index = index -1;
                }
            }
            String temp = hits.get(index);
            hits.set(index, hits.get(i));
            hits.set(i, temp);
        }
        return hits;
    }

    //shuffle the even ticks
    public static List<String> shuffleEvens(int ticksPerStaff, int numberOfBeats, List<String> beatList){
        //Eventual list of the even indexes
        List<Integer> evens = new ArrayList<>();

        //add to the evens arraylist
        for (int i = 0; i < ticksPerStaff; i++){
            if (i % 2 == 0){
                evens.add(i);
            }
        }

        //shuffle the evens
        evens = UtilityFunctions.shuffleArray(evens);
        //add the drum beats in all of the correct places
        for (int x = 0; x < numberOfBeats; x++ ){
            beatList.set(evens.get(x), "hit");
        }

        //add spaces to the correct places
        for (int a = 0; a < ticksPerStaff; a++){
            if (!beatList.get(a).equals("hit")){
                beatList.set(a, "space");
            }
        }

        return beatList;
    }

    //shuffle the odd ticks
    public static List<String> shuffleOdds(int ticksPerStaff, int numberOfBeats, List<String> beatList){
        List<Integer> odds = new ArrayList<>();
        for (int i = 0; i < ticksPerStaff; i++){
            if (i % 2 != 0){
                odds.add(i);
            }
        }

        odds = UtilityFunctions.shuffleArray(odds);
        for (int x = 0; x < numberOfBeats; x++){
            beatList.set(odds.get(x), "hit");
        }
        for (int a = 0; a < ticksPerStaff; a++){
            if (!beatList.get(a).equals("hit")){
                beatList.set(a, "space");
            }
        }

        return beatList;
    }

}