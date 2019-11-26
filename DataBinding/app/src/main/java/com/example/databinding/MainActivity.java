package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        User userOne = new User("Mostafa","Akash");
        binding.setUser(userOne);
        //setSupportActionBar(binding.toolbarIdMain);

    }

}
