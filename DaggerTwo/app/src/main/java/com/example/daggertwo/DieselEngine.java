package com.example.daggertwo;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements Engine {
    private static final String TAG = "Car";
    @Inject
    public DieselEngine()
    {

    }
    @Override
    public void start() {
        Log.wtf(TAG,"Diesel engine is started");
    }
}
