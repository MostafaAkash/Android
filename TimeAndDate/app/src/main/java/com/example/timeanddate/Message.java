package com.example.timeanddate;

import android.content.Context;
import android.widget.Toast;

public class Message {
    public static void mesaage(Context context,String data)
    {
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
    }
}
