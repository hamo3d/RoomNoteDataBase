package com.example.roomdatabase.room_database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;


    public NoteViewModel (Application application) {
        super(application);
        noteRepository = new NoteRepository(application);

    }

    public void insertNote (Note note){
        noteRepository.insert(note);
    }

    public LiveData<List<Note>> getAllEmployees(){
        return noteRepository.getAllEmployees();
    }


}
