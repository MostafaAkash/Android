package com.example.factorymehodsenddata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExampleFragment exampleFragment = ExampleFragment.newInstanceOfFragment("example text ",140128);
        /*
        Bundle args = new Bundle();
        args.putString("argText","example text ");
        args.putInt("argNumber",140128);
        exampleFragment.setArguments(args);*/
        getSupportFragmentManager().beginTransaction().replace(R.id.container_in_main,exampleFragment).commit();



    }
}
