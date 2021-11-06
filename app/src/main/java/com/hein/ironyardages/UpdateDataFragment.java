package com.hein.ironyardages;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UpdateDataFragment extends Fragment {

    //  Initialize variable
    private EditText upClub, upMen, upWomen;
    private Button btn_Update;

    public UpdateDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_data, container, false);
        //Assign variable
        upClub = view.findViewById(R.id.updateClub);
        upMen = view.findViewById(R.id.updateMen);
        upWomen = view.findViewById(R.id.updateWomen);
        btn_Update = view.findViewById(R.id.btnUpdate);

        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Get string from edit text
                String club = upClub.getText().toString();
                String men = upMen.getText().toString();
                String women = upWomen.getText().toString();

                //  Initialize club data
                Club clubs = MainActivity.clubDatabase.clubDAO().getClubByName(club);
                // Set club variable on club data
                clubs.setMen(men);
                clubs.setWomen(women);

                //  Update database with new updated data
                MainActivity.clubDatabase.clubDAO().update(clubs);
                //  Notify data is saved
                Toast.makeText(getActivity(), "Data is updated", Toast.LENGTH_LONG).show();
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.Container, new ViewFragment(), null)
                        .commit();
            }
        });

        return view;
    }
}