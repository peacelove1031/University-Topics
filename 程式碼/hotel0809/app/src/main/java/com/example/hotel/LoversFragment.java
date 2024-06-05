package com.example.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class LoversFragment extends Fragment implements View.OnClickListener {

    Button travel_live,travel,map;
    Intent Lovers_Intent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lovers, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        travel_live = getActivity().findViewById(R.id.travel_live);
        travel = getActivity().findViewById(R.id.travel);
        map = getActivity().findViewById(R.id.map);

        travel_live.setOnClickListener(this);
        travel.setOnClickListener(this);
        map.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.travel_live:
                Lovers_Intent = new Intent(this.getContext(),lovers_lodging.class);
                next();
                break;
            case R.id.travel:
                Lovers_Intent = new Intent(this.getContext(),lovers_sight.class);
                next();
                break;
            case  R.id.map:
                Lovers_Intent = new Intent(this.getContext(),lover_transportation.class);
                next();
                break;
        }
    }
    //intent
    public void next ()
    {
        startActivity(Lovers_Intent);
    }
}