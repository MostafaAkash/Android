package com.example.recycleviewwithlistener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private String[] name={"Virat","Smith","Williamson","Shakib","Sangakara","Rohit","Musfiq","Mashrafi","Joe Root","Ben Stokes","Babar Azam"};
    private String[] country={"India","Australia","Newzealand","Bangladesh","Srilanka","Inida","Bangladesh","Bangladesh","England","England","Pakistan"};
    private String[] rankId={"Rank: 1","Rank: 2","Rank: 3","Rank: 4","Rank: 5","Rank: 6","Rank: 7","Rank: 8","Rank: 9","Rank: 10","Rank: 11"};
    private int[] imageId = {R.drawable.virat,R.drawable.smith,R.drawable.williamson,R.drawable.shakib,R.drawable.sanga,R.drawable.rohit,R.drawable.musfiq,R.drawable.mash,R.drawable.joeroot,R.drawable.benstokes,R.drawable.babarazam,};
    private ArrayList<Player> playerArrayList;

    private RecyclerView recyclerView;
    private PlayerAdapter adapter;
    private Button insertButton,deleteButton;
    private EditText editTextOne,editTextTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createArrayList();
        buildRecycleView();
        init();

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerArrayList.remove(playerArrayList.size()-1);
                adapter.notifyDataSetChanged();
            }
        });


        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameText = editTextOne.getText().toString().trim();
                String countryText = editTextTwo.getText().toString().trim();
                playerArrayList.add(new Player(R.drawable.ic_image_black_24dp,nameText,countryText,"Rank "+(playerArrayList.size()+1)));
                editTextTwo.onEditorAction(EditorInfo.IME_ACTION_DONE);

                adapter.notifyDataSetChanged();

                editTextOne.getText().clear();
                editTextTwo.getText().clear();

            }
        });







    }

    private void init() {
        insertButton = findViewById(R.id.submit_id_main_ac);
        editTextOne = findViewById(R.id.name_edit_id_main_ac);
        editTextTwo = findViewById(R.id.country_edit_main_ac);
        deleteButton = findViewById(R.id.delete_Button_id_main_ac);
    }

    private void buildRecycleView() {

        recyclerView = findViewById(R.id.recycleviewid_main_ac);
        // recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlayerAdapter(this,playerArrayList);
        recyclerView.setAdapter(adapter);
        adapter.setOnRecycleViewItemClickListener(new PlayerAdapter.OnRecycleViewItemClickListener() {
            @Override
            public void onRecycleViewItemClick(int position) {
                Toast.makeText(MainActivity.this, "Clicked On Item: "+position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void createArrayList() {
        playerArrayList = new ArrayList<>();
        for(int i=0;i<name.length;i++)
        {
            playerArrayList.add(new Player(imageId[i],name[i],country[i],rankId[i]));
        }
    }


}
