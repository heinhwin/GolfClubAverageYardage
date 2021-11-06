package com.hein.ironyardages;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDataFragment extends Fragment {

    private EditText inputClub, inputMen, inputWomen;
    private Button btnSave;

    public AddDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_data, container, false);
        inputClub = view.findViewById(R.id.inputClub);
        inputMen = view.findViewById(R.id.inputMen);
        inputWomen = view.findViewById(R.id.inputWomen);
        btnSave = view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Get string from edit text
                String club = inputClub.getText().toString();
                String men = inputMen.getText().toString();
                String women = inputWomen.getText().toString();

                //  Initialize club data
                Club clubs = new Club();
                //  Set club variable on club data
                clubs.setClub(club);
                clubs.setMen(men);
                clubs.setWomen(women);

                //  Add new data to the database
                MainActivity.clubDatabase.clubDAO().insert(clubs);
                //  Notify data is saved
                Toast.makeText(getActivity(), "Data is saved", Toast.LENGTH_LONG).show();
                //  Clear edit text
                inputClub.setText("");
                inputMen.setText("");
                inputWomen.setText("");
            }
        });

        return view;
    }
}