package com.example.timeanddate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.timeanddate.databinding.ActivityMainBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {


    ActivityMainBinding binding;
   // private TimePicker timePicker;
    DatePickerDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.pickTimeBtnId.setOnClickListener(this);
        callTimePicker();
        binding.pickTimeWithClockRound.setOnClickListener(this);
        binding.pickDateWithClockRound.setOnClickListener(this);
        binding.openFragmentInMainAc.setOnClickListener(openFragment);

    }
    private View.OnClickListener openFragment = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),CalenderPicker.class);
            startActivity(intent);

        }
    };

    public void callTimePickerWithDialog() {
        DialogFragment dialogFragment = new TimePickerFragment();
        dialogFragment.show(getSupportFragmentManager(),"Time Picker");

    }

    private void callTimePicker() {

        binding.timePickerMain.setIs24HourView(false);
        binding.timePickerMain.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String period = " am";
                if(hourOfDay>=12)
                {
                    hourOfDay = hourOfDay - 12;
                    period = " pm";
                }
                binding.setCkOneTimeTxtView.setText(hourOfDay+" : "+minute+period);

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.pickTimeBtnId)
        {
            binding.currentTimeTextView.setText(getDateTime());
        }

        if(v.getId() == R.id.pickTimeWithClockRound)
        {
            callTimePickerWithDialog();
        }
        if(v.getId() == R.id.pickDateWithClockRound)
        {
            pickDateWithRoundClock();
        }

    }

    private void pickDateWithRoundClock() {

       /* Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
       dialog = new DatePickerDialog(this, (DatePickerDialog.OnDateSetListener)getApplicationContext(),year,month,day);
       dialog.show();*/

       Calendar cal = Calendar.getInstance();

        DatePickerDialog datePicker = new DatePickerDialog(this, datePickerListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));
        //Create a cancel button and set the title of the dialog.
        datePicker.setCancelable(false);
        datePicker.setTitle("Select the date");
        datePicker.show();

    }
    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            binding.currentTimeTextView.setText(dayOfMonth+"/"+(month+1)+"/"+year);
        }
    };

    private String getDateTime()
    {
        Calendar calendar = Calendar.getInstance();
        /*int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day+"/"+month+"/"+year;*/
        SimpleDateFormat sdf = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
        Date now = calendar.getTime();
        return sdf.format(now);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        binding.setCkTwoTxtView.setText(hourOfDay+" : "+minute);
    }

}