package com.example.roomdatabase.room_database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
     NoteDao noteDao;

    NoteRepository(Application application) {
        NoteRoomDataBase db = NoteRoomDataBase.getDatabase(application);
        noteDao = db.noteDao();

    }


    void insert(Note note) {
        NoteRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.insertNote(note);
            }
        });
    }
    LiveData<List<Note>> getAllEmployees(){
        return noteDao.getAllNote();
    }
}
