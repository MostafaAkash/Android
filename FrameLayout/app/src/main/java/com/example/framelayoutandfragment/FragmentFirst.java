package com.example.framelayoutandfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentFirst extends Fragment implements View.OnClickListener {

    private Button button;
    private int counter=0;
    private Communicator communicator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null)
        {
            counter = 0;
        }
        else
        {
            counter = savedInstanceState.getInt("counterKey",0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fagment_first,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button = getActivity().findViewById(R.id.button_fragment_first_ac);
        communicator = (Communicator) getActivity();

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        counter++;
        communicator.respond("Button Clicked "+ counter+" Times");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counterKey",counter);
    }
}
