package com.example.notelesson8;

public class NoteData {
    private String title;
    private String message;


    public String getTitle() {
        return title;
    }
    public String getMessage() {
        return message;
    }

    public NoteData(String title, String message) {
        this.title = title;
        this.message = message;
    }

}
