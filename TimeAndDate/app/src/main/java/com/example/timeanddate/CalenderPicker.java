package com.example.timeanddate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class CalenderPicker extends AppCompatActivity {
    private CalendarView calendarView;
    private ImageView imageView;
    private static final int RESULT_CODE = 122;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_picker);
        calendarView = findViewById(R.id.calenderPickerView);
        calendarView.setOnDateChangeListener(dayChanceListener);
        imageView = findViewById(R.id.imageLoadFromNet);
      //  loadImage();
        imageView.setOnClickListener(listener);

    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent gallery = new Intent();
            gallery.setType("image/*");
            gallery.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(gallery,"Image Picker"),RESULT_CODE);
        }
    };

    private void loadImage() {
        String url ="C:\\Users\\slowg\\Downloads\\DSC_0006.jpg";
        Picasso.get().load(url).into(imageView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==RESULT_CODE && resultCode==RESULT_OK)
        {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                imageView.setImageBitmap(bitmap);
            }catch (Exception e)
            {
                Message.mesaage(this,"Error Occurred");
            }
        }
    }

    private CalendarView.OnDateChangeListener dayChanceListener = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            Message.mesaage(getApplicationContext(),dayOfMonth+"/"+(month+1)+"/"+year);
        }
    };

}
