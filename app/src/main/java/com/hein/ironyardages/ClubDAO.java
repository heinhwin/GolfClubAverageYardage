package com.hein.ironyardages;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ClubDAO {

    //Get all data query
    @Query("SELECT * FROM table_club")
    public List<Club> getClub();

    //Insert query
    @Insert
    public void insert(Club club);

    //Update query
    @Update
    public void update(Club club);

    //Delete query
    @Delete
    public void delete(Club club);

    @Query("Select * from table_club where club = :name limit 1")
    public Club getClubByName(String name);
}
