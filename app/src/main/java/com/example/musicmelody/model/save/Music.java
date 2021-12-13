package com.example.musicmelody.model.save;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Music {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "musicID")
    public String musicID;

    @ColumnInfo(name = "song")
    public String title;

    @ColumnInfo(name = "artist")
    public String subtitle;

}
