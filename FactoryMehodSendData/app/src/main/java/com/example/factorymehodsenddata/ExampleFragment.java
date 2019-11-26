package com.example.factorymehodsenddata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ExampleFragment extends Fragment {
    private static final String ARG_TEXT = "argText";
    private static final String ARG_NUMBER = "argNumber";


    private String txt;
    private int number;

    public static ExampleFragment newInstanceOfFragment(String text,int number)
    {
        ExampleFragment fragment = new ExampleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TEXT,text);
        bundle.putInt(ARG_NUMBER,number);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.example_fragment,container,false);
        TextView textView = v.findViewById(R.id.textView_in_ex_ac);
        if(getArguments() != null)
        {
            txt = getArguments().getString(ARG_TEXT);
            number = getArguments().getInt(ARG_NUMBER);
        }
        textView.setText(txt+number);
        return v;
    }
}
