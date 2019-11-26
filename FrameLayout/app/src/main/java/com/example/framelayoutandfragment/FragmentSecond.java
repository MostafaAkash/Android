package com.example.framelayoutandfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSecond extends Fragment {

    private TextView textView;
    private String data;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.second_fragment,container,false);

        if(savedInstanceState == null)
        {

        }
        else
        {
            data = savedInstanceState.getString("text");
            TextView textView = view.findViewById(R.id.textView_sec_frag_ac);
            textView.setText(data);
        }
        return  view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = getActivity().findViewById(R.id.textView_sec_frag_ac);
    }
    public void changeText(String data)
    {
        this.data = data;
        textView.setText(data);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text",data);
    }
}
