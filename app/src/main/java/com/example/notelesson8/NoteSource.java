package com.example.notelesson8;

public interface NoteSource {
    int size();
    NoteData getNoteData(int position);
    void addNoteData(NoteData newNoteData);
    void clearNoteData();
    void deleteNoteData(int position);
}
