package com.example.roomdatabase.room_database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String info;

    public Note() {
    }

    public Note(int id, String title, String info) {
        this.id = id;
        this.title = title;
        this.info = info;
    }

    public Note(String title, String info) {
        this.title = title;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
