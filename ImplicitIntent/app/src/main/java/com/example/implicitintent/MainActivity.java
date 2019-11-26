package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.implicitintent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.openMapIdMainAc.setOnClickListener(this);
        binding.sendSmsBtnMain.setOnClickListener(this);
        binding.sendMailIdMainAc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        Intent chooser = null;
        if(v.getId()==R.id.open_map_id_main_ac)
        {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://translate.google.com.bd/?hl=bn#view=home&op=translate&sl=en&tl=bn"));
            chooser = Intent.createChooser(intent,"Launch Google website");
            startActivity(chooser);
            Message.message(this,"Clicked on First Button");

        }
        else if(v.getId() == R.id.sendSmsBtnMain)
        {
            Uri sms = Uri.parse("smsto:01989001865");
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO,sms);
            smsIntent.putExtra("sms_body","Hello How are you?");
            startActivity(smsIntent);

        }
        else if(v.getId()==R.id.send_mail_id_main_ac)
        {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to= {"akash.pop.ru@gmail.com","realhost86@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"Check Mail");
            intent.putExtra(Intent.EXTRA_TEXT,"Hi! how are you??");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent,"Send Mail");
            startActivity(chooser);

        }

    }
}
