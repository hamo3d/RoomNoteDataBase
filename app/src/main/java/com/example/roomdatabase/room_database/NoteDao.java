package com.example.roomdatabase.room_database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insertNote (Note notes);

    @Query("select * from note_table ")
    LiveData<List<Note>> getAllNote ();
}
