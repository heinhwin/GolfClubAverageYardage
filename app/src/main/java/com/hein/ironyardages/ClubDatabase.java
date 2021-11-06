package com.hein.ironyardages;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//Add database entities
@Database(entities = {Club.class}, version = 2)
public abstract class ClubDatabase extends RoomDatabase {
    //Define database name
    private static final String DATABASE_NAME = "club.db";
    //Create database instance
    private static ClubDatabase clubDatabase;

    public synchronized static ClubDatabase getInstance(Context context) {
        if (clubDatabase == null) {
            //When database is null
            //Initialize database
            clubDatabase = Room.databaseBuilder(context, ClubDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        //Return Database
        return clubDatabase;
    }

    //Create Dao
    public abstract ClubDAO clubDAO();

}
