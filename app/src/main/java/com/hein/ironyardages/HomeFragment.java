package com.hein.ironyardages;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Update;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btnAdd, btnView, btnUpdate;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnAdd = view.findViewById(R.id.add);
        btnView = view.findViewById(R.id.view);
        btnUpdate = view.findViewById(R.id.update);

        btnAdd.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        //  Case for different button click
        switch (view.getId())
        {
            case R.id.add:
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.Container, new AddDataFragment(), null)
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.view:
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.Container, new ViewFragment(), null)
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.update:
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.Container, new UpdateDataFragment(), null)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}