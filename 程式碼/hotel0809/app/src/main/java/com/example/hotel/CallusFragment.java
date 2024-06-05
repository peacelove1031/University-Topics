package com.example.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;


public class CallusFragment extends Fragment implements View.OnClickListener {
    private Button story,official,service;
    private Intent Callus_Intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_callus, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        story = getActivity().findViewById(R.id.story);
        official = getActivity().findViewById(R.id.official);
        service = getActivity().findViewById(R.id.service);

        story.setOnClickListener(this);
        official.setOnClickListener(this);
        service.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.story:
                Callus_Intent = new Intent(this.getContext(),callus_story.class);
                next();
                break;
            case R.id.official:
                Callus_Intent = new Intent(this.getContext(),callus_official.class);
                next();
                break;
            case  R.id.service:
                Callus_Intent = new Intent(this.getContext(),callus_service.class);
                next();
                break;
        }
    }
    //intent
    public void next ()
    {
        startActivity(Callus_Intent);
    }
}