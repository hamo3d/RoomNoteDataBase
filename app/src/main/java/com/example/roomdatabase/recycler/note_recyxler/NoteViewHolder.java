package com.example.roomdatabase.recycler.note_recyxler;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.databinding.NoteItemBinding;
import com.example.roomdatabase.interfaces.OnclickItem;
import com.example.roomdatabase.room_database.Note;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    NoteItemBinding binding;
    OnclickItem onclickItem;
    Note note;
    public NoteViewHolder(NoteItemBinding binding , OnclickItem onclickItem) {
        super(binding.getRoot());
        this.binding = binding;
        this.onclickItem = onclickItem;
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclickItem.clickItem(note);
            }
        });
    }
    public void setData (Note note){
        binding.titleTextView.setText(note.getTitle());
        binding.infoTextView.setText(note.getInfo());
    }


}
