package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // getSupportFragmentManager().beginTransaction().replace(R.id.frame_in_main,new HomeFragment()).commit();
        openFragment(new HomeFragment());

        BottomNavigationView btmNav = findViewById(R.id.bottom_nav_id);
        btmNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            //Fragment selectedFragment = null;
            switch (menuItem.getItemId())
            {
                case R.id.home_icon_id:
              //      selectedFragment = new HomeFragment();
                    openFragment(new HomeFragment());
                    break;
                case R.id.faovorite_icin_id:
                    //selectedFragment = new FavoriteFragment();
                    openFragment(new FavoriteFragment());
                    break;
                case R.id.serach_icon_id:
                    //selectedFragment = new SearchFragment();
                    openFragment(new SearchFragment());
                    break;
            }

           // getSupportFragmentManager().beginTransaction().replace(R.id.frame_in_main,selectedFragment).commit();

            return true;
        }
    };
    private void openFragment(Fragment fragment)
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_in_main,fragment).commit();
    }
}
