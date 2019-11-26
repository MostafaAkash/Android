package com.example.framelayoutandfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CheckBoxActivity extends AppCompatActivity {
    private CheckBox checkBox;
    private ToggleButton toggleButton;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        init();
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CheckBox check = (CheckBox) v;
                if(checkBox.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"You want "+checkBox.getText().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"You don't want "+checkBox.getText().toString(),Toast.LENGTH_SHORT).show();

                }
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    relativeLayout.setBackgroundColor(Color.rgb(47, 69, 98));

                }
                else
                {
                    relativeLayout.setBackgroundColor(Color.WHITE);
                }
            }
        });
    }

    private void init() {
        checkBox = findViewById(R.id.checkbox_chec_ac);
        toggleButton = findViewById(R.id.toggleButton);
        relativeLayout = findViewById(R.id.check_box_latout);

    }
}
