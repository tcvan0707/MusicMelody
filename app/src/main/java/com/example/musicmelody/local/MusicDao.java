package com.example.musicmelody.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.musicmelody.model.save.Music;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MusicDao {

    @Query("SELECT * FROM music")
    List<Music> getAll();

    @Query("DELETE FROM music where musicID = :musicID ")
    void delete(String musicID);

    @Query("DELETE FROM music")
    void deleteAll();

    @Insert
    void insert(Music music);
}
