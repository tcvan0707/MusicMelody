package com.example.musicmelody.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.musicmelody.model.save.Music;


@Database(entities = { Music.class }, version = 1)
public abstract class MusicDatabase extends RoomDatabase {

        public abstract MusicDao getMusicDao();
        private static MusicDatabase musicDB;

        public static MusicDatabase getInstance(Context context) {
            if (null == musicDB) {
                musicDB = buildDatabaseInstance(context);
            }
            return musicDB;
            }

        private static MusicDatabase buildDatabaseInstance(Context context) {
            return Room.databaseBuilder(context,
                    MusicDatabase.class,
                    "musicDB")
            .allowMainThreadQueries().build();
        }

        public void cleanUp(){
            musicDB = null;
        }
}