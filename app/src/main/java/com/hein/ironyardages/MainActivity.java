package com.hein.ironyardages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Initialize fragment manager & database
    static FragmentManager fragmentManager;
    static ClubDatabase clubDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hide ActionBar on top
        getSupportActionBar().hide();

        //Build a database
        fragmentManager = getSupportFragmentManager();
        clubDatabase = Room.databaseBuilder(getApplicationContext(), ClubDatabase.class, "clubdb")
                            .allowMainThreadQueries()
                            .build();

        if(findViewById(R.id.Container) != null) {
            if(savedInstanceState != null) {
                return;
            }
            fragmentManager.beginTransaction().replace(R.id.Container, new HomeFragment(), null).commit();
        }
    }
}