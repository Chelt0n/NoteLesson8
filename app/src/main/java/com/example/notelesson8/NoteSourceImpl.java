package com.example.notelesson8;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class NoteSourceImpl implements NoteSource,Parcelable {
    private List<NoteData> dataSource;
    private Resources resources;

    public NoteSourceImpl(Resources resources) {
        dataSource = new ArrayList<>();
        this.resources = resources;
    }


    protected NoteSourceImpl(Parcel in) {
    }

    public static final Creator<NoteSourceImpl> CREATOR = new Creator<NoteSourceImpl>() {
        @Override
        public NoteSourceImpl createFromParcel(Parcel in) {
            return new NoteSourceImpl(in);
        }

        @Override
        public NoteSourceImpl[] newArray(int size) {
            return new NoteSourceImpl[size];
        }
    };

    public NoteSourceImpl init(){
        String[] title = resources.getStringArray(R.array.title);
        String[] message = resources.getStringArray(R.array.note);
        for (int i = 0; i < title.length; i++) {
            dataSource.add(new NoteData(title[i],message[i]));
        }
        return this;
    }

    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public NoteData getNoteData(int position) {
        return dataSource.get(position);
    }

    @Override
    public void addNoteData(NoteData newNoteData) {
        dataSource.add(newNoteData);
    }

    @Override
    public void clearNoteData() {
        dataSource.clear();
    }

    @Override
    public void deleteNoteData(int position) {
        dataSource.remove(position);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
