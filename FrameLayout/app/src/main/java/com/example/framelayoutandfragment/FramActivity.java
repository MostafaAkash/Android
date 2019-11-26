package com.example.framelayoutandfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FramActivity extends AppCompatActivity {
    private ImageView imageViewCat,rabitImage,dogImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fram);

        init();
    }

    private void init() {
        imageViewCat = findViewById(R.id.cat_image);
        rabitImage = findViewById(R.id.rabbitimage);
        dogImage = findViewById(R.id.dog_image);
    }

    public void onClickEvent(View v) {

        if(v.getId() == R.id.cat_image)
        {
            imageViewCat.setVisibility(View.GONE);
            rabitImage.setVisibility(View.GONE);
            dogImage.setVisibility(View.VISIBLE);
        }
        if(v.getId() == R.id.dog_image)
        {
            imageViewCat.setVisibility(View.GONE);
            rabitImage.setVisibility(View.VISIBLE);
            dogImage.setVisibility(View.GONE);
        }
        if(v.getId() == R.id.rabbitimage)
        {
            imageViewCat.setVisibility(View.VISIBLE);
            rabitImage.setVisibility(View.GONE);
            dogImage.setVisibility(View.GONE);
        }

    }

}
