package com.example.roomdatabase.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roomdatabase.R;
import com.example.roomdatabase.databinding.ActivityAddNoteBinding;
import com.example.roomdatabase.room_database.Note;
import com.example.roomdatabase.room_database.NoteViewModel;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityAddNoteBinding binding;

    NoteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setOnclickListener();
    }



    private void setOnclickListener (){
        binding.saveNoteButton.setOnClickListener(this);
    }
    private void checkData (){
        if (check()){
            setData();
        }

    }

    private boolean check (){
        if (!binding.titleEditText.getText().toString().isEmpty() && !binding.infoEditText.getText().toString().isEmpty()){
            return true;

        }else {
            Toast.makeText(this, "enter data", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private void setData (){
        String title = binding.titleEditText.getText().toString() ;
        String info = binding.infoEditText.getText().toString();
        viewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        viewModel.insertNote(new Note(title,info));
        onBackPressed();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.save_note_button){
            checkData();
        }
    }
}
