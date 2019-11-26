package com.example.daggertwo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

public class Remote {
    private static final String TAG = "Car";

    @Inject
    public Remote()
    {

    }
    public void setListener(Car car)
    {
        Log.wtf(TAG,"Remote Connected");

    }


}
