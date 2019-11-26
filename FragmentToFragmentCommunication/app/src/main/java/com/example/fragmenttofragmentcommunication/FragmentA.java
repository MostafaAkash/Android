package com.example.fragmenttofragmentcommunication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {
    private FragmentAListener listener;
    private EditText editText;
    private Button btn;
    public interface FragmentAListener{
        void onInputASent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a,container,false);
        editText = v.findViewById(R.id.edit_text_id_fragment_a_ac);
        btn = v.findViewById(R.id.ok_btn_id_fragment_a_ac);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputASent(input);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAListener)
        {
            listener = (FragmentAListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()+" Must have to implement FragmentAListener");
        }
    }

    public void updateEditText(CharSequence newText)
    {
        editText.setText(newText);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listener = null;
    }
}
