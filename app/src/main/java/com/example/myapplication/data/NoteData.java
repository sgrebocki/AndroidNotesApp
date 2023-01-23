package com.example.myapplication.data;

public class NoteData {
    String Title;
    String Description;

    public NoteData(String title, String description) {
        this.Title = title;
        this.Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }
}
