package com.example.roomdatabase.recycler.note_recyxler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.databinding.NoteItemBinding;
import com.example.roomdatabase.interfaces.OnclickItem;
import com.example.roomdatabase.room_database.Note;

import java.util.List;

public class NoteViewAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    List<Note> notes;
    OnclickItem onclickItem;

    public NoteViewAdapter(List<Note> notes, OnclickItem onclickItem) {
        this.notes = notes;
        this.onclickItem = onclickItem;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NoteItemBinding binding = NoteItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NoteViewHolder(binding,onclickItem);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.setData(notes.get(position));

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
