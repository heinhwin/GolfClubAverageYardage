package com.hein.ironyardages;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Define table name
@Entity(tableName = "table_club")
public class Club {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long Id;

    //Initialize variable
    private String club;
    private String men;
    private String women;

    //Set Getter & Setter
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getMen() {
        return men;
    }

    public void setMen(String men) {
        this.men = men;
    }

    public String getWomen() {
        return women;
    }

    public void setWomen(String women) {
        this.women = women;
    }
}
