package com.dmill.Algorithms.Drums;

import com.dmill.Algorithms.Util.CollectionShuffle;


public class BlexAlgorithm extends BeatAlgorithms {

    //Utility algorithm used for shuffling - used for this class
    private CollectionShuffle collectionShuffle = new CollectionShuffle();

    protected BlexAlgorithm(Builder builder){
        super(builder);
    }

    protected void usePreset(){

    }

    public void setUp(){
    }

    public void execute(){

    }

    public void toMidi(){
        System.out.println("hit Here");
    }
}
