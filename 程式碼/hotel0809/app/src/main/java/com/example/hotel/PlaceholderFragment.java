package com.example.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class PlaceholderFragment extends Fragment implements View.OnClickListener {
    private Button food,travel,season;
    private Intent food_Intent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        food = getActivity().findViewById(R.id.food);
        travel = getActivity().findViewById(R.id.travel);
        season = getActivity().findViewById(R.id.season);

        food.setOnClickListener(this);
        travel.setOnClickListener(this);
        season.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.food:
                food_Intent = new Intent(this.getContext(),placeholder_food.class);
                next();
                break;
            case R.id.travel:
                food_Intent = new Intent(this.getContext(),placeholder_journey_suitcase.class);
                next();
                break;
            case  R.id.season:
                food_Intent = new Intent(this.getContext(),placeholder_season.class);
                next();
                break;
        }
    }
    //intent
    public void next ()
    {
        startActivity(food_Intent);
    }
}