package com.example.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment implements View.OnClickListener {

    ImageButton roomservice,information,epidemic,token,quicksearch;
    private Intent Home_Intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        ViewFlipper viewFlipper = (ViewFlipper) getActivity().findViewById(R.id.viewflipper);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(3000);
        if (viewFlipper.isAutoStart() && !viewFlipper.isFlipping()) {
            viewFlipper.startFlipping();
        }
        roomservice = getActivity().findViewById(R.id.roomservice);
        information = getActivity().findViewById(R.id.information);
        epidemic = getActivity().findViewById(R.id.epidemic);
        token =getActivity().findViewById(R.id.token);
        quicksearch = getActivity().findViewById(R.id.quick_search);

        roomservice.setOnClickListener(this);
        information.setOnClickListener(this);
        epidemic.setOnClickListener(this);
        token.setOnClickListener(this);
        quicksearch.setOnClickListener(this);

    }
    //button of event
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.roomservice:
                Home_Intent = new Intent(this.getContext(), com.example.hotel.roomservice.class);
                next();
                break;
            case  R.id.information:
                Home_Intent = new Intent(this.getContext(),com.example.hotel.instant.class);
                next();
                break;
            case  R.id.epidemic:
                Home_Intent = new Intent(this.getContext(),com.example.hotel.epidemic_prevention.class);
                next();
                break;
            case  R.id.token:
                Home_Intent = new Intent(this.getContext(),com.example.hotel.pass_token.class);
                next();
                break;
            case  R.id.quick_search:
                Home_Intent = new Intent(this.getContext(),com.example.hotel.quick_search.class);
                next();
                break;
        }

    }
    //intent
    public void next ()
    {
        startActivity(Home_Intent);
    }
    //alert message

}



