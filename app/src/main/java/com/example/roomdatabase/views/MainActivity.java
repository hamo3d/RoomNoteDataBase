package com.example.roomdatabase.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roomdatabase.R;
import com.example.roomdatabase.databinding.ActivityMainBinding;
import com.example.roomdatabase.interfaces.OnclickItem;
import com.example.roomdatabase.recycler.note_recyxler.NoteViewAdapter;
import com.example.roomdatabase.room_database.Note;
import com.example.roomdatabase.room_database.NoteViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding ;
    List<Note> notes = new ArrayList<>();
    NoteViewModel viewModel;
    NoteViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(NoteViewModel.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        init();
    }


    private void init(){
        setAdapter();
        setOnclickListener();
    }

    private void setAdapter (){
        adapter = new NoteViewAdapter(notes, new OnclickItem() {
            @Override
            public void clickItem(Note note) {
                Toast.makeText(MainActivity.this, "note.getTitle()", Toast.LENGTH_SHORT).show();
            }
        });
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getAllEmployees().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.setNotes(notes);
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void setOnclickListener(){
        binding.floatingActionButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.floatingActionButton){
            Intent intent = new Intent(getApplicationContext(),AddNoteActivity.class);
            startActivity(intent);
        }
    }
}