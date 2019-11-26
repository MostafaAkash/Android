package com.example.daggertwo;

import android.util.Log;

import javax.inject.Inject;

public class PetrolEngine implements Engine {
    private static final String TAG = "Car";
    private int horsePower;
    @Inject
    public PetrolEngine(int horsePower)
    {
        this.horsePower = horsePower;
    }
    @Override
    public void start() {
        Log.wtf(TAG,"Petrol engine is started + HorsePower: "+horsePower);
    }
}
