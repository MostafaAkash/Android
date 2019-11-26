package com.example.sqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   // MyDatabaseHelper helper;
    MyDatabaseAdapter adapter;

    private EditText nameText,ageText,genderText,idEditTxt,startAge,endAge,nameDeleteEditText,updateNameEditText,oldNameEditText;
    private Button addButton,showData,submit,searchButton,deleteButton,updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MyDatabaseAdapter(this);
        init();
        clickListener();

    }

    @Override
    public void onClick(View v) {
        String name,gender;
        String age;
        String id;
        name = nameText.getText().toString();
        age = ageText.getText().toString();
        gender = genderText.getText().toString();

        if(v.getId() == R.id.add_button_id)
        {
            long rowId = adapter.insertData(name, Integer.valueOf(age),gender);
            if(rowId == -1)
            {
                Message.message(this,"Not inserted Data");
            }
            else
            {
                Message.message(this,"Successfully Inserted Row");
            }
        }
        else if(v.getId() == R.id.show_data_main_ac)
        {

            String data = adapter.retrieveData();
            displayData("ResultSet",data);
        }
        else if(v.getId() == R.id.submit_for_show_main_ac)
        {
            id = idEditTxt.getText().toString().trim();
            if(id!=null  && !id.isEmpty())
            {
               // Message.message(this,"Id = "+ id);
                String data = adapter.getDatabasedOnId(id);
                displayData("ResultSet",data);

            }

        }
        else if(v.getId() == R.id.search_id_main_ac)
        {
            String start,end,data;
            start = startAge.getText().toString().trim();
            end = endAge.getText().toString().trim();
            //Message.message(this,"Start Age: "+start+"\nEndAge:"+end);
          data = adapter.getDataBetweenAge(start,end);
          displayData("ResultSet",data);

        }
        else if(v.getId() == R.id.delete_btn_main_ac)
        {
            String nameDeleteText= nameDeleteEditText.getText().toString().trim();
            int rowNumber = adapter.deleteRowDataBasedOnName(nameDeleteText);
            Message.message(this,"Successfully Deleted Row Number: "+rowNumber);
            String data = adapter.retrieveData();
            displayData("ResultSet",data);

        }
        else if(v.getId() == R.id.update_btn_main_ac)
        {
            String newName,oldName;
            newName = updateNameEditText.getText().toString().trim();
            oldName = oldNameEditText.getText().toString().trim();
            adapter.updateName(oldName,newName);
            Message.message(this,"Successfully Updated");
        }


    }


    private void displayData(String title, String data) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(data);
        builder.setCancelable(true);
        builder.show();
    }

    private void init()
    {

        searchButton = findViewById(R.id.search_id_main_ac);
        showData = findViewById(R.id.show_data_main_ac);
        nameText = findViewById(R.id.name_edit_id);
        ageText = findViewById(R.id.age_edit_id);
        genderText = findViewById(R.id.gender_edit_text);
        idEditTxt = findViewById(R.id.id_editText_main_ac);
        addButton = findViewById(R.id.add_button_id);
        submit = findViewById(R.id.submit_for_show_main_ac);
        startAge = findViewById(R.id.from_age_id);
        endAge = findViewById(R.id.to_edit_text_id);
        deleteButton = findViewById(R.id.delete_btn_main_ac);
        nameDeleteEditText = findViewById(R.id.delete_name_edit_text);
        updateNameEditText = findViewById(R.id.update_name_edit_text);
        updateButton = findViewById(R.id.update_btn_main_ac);
        oldNameEditText = findViewById(R.id.old_name_edit_text);

    }

    private void clickListener()
    {

        addButton.setOnClickListener(this);
        showData.setOnClickListener(this);
        submit.setOnClickListener(this);
        searchButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
    }
}
