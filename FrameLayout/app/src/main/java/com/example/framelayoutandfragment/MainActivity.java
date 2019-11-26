package com.example.framelayoutandfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Communicator{
   private Button buttonOne,buttonTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    init();

    buttonOne.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openActivity(getApplicationContext(),FramActivity.class);
        }
    });
    buttonTwo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openActivity(getApplicationContext(), CheckBoxActivity.class);
        }
    });
/*
        FragmentFirst fragment = new FragmentFirst();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.ral_lay_main_ac,fragment,"FirstFragmentCreated");
        transaction.commit();
;*/


    }

    private void init() {
        buttonOne = findViewById(R.id.first_button_main_ac);
        buttonTwo = findViewById(R.id.second_button_main_ac);

    }

    public void openActivity(Context context,Class cls)
    {
        Intent intent = new Intent(context,cls);
        startActivity(intent);
    }


    @Override
    public void respond(String data) {
         FragmentManager manager = getSupportFragmentManager();
         FragmentSecond second = (FragmentSecond) manager.findFragmentById(R.id.second_frag_id_main_ac);
         second.changeText(data);
    }
}
