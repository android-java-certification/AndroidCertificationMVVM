package com.roscasend.android.androidcertificationmvvm.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.roscasend.android.androidcertificationmvvm.model.bean.Note;
import com.roscasend.android.androidcertificationmvvm.model.dao.NoteDao;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
            .build();
        }
        return instance;
    }
}
