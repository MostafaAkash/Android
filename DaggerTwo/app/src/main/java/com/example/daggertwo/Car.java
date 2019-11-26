package com.example.daggertwo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.Provides;

public class Car {
    private static final String TAG = "Car";
    private Engine engine;
    private Wheel wheel;
    @Inject
    public Car(Engine engine, Wheel wheel) {
        this.engine = engine;
        this.wheel = wheel;
    }
    @Inject
    public void enableRemote(Remote remote)
    {
        remote.setListener(this);
    }
    public void drive(Context context)
    {
        engine.start();
        Toast.makeText(context, "Driving...", Toast.LENGTH_SHORT).show();
        Log.wtf(TAG,"Driving...");
    }



}
