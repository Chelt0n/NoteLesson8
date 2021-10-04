package com.example.notelesson8;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentNote extends Fragment {
    public static String ARG_NOTE = "NOTE";
    NoteSource data;

    public static FragmentNote newInstance(NoteSource data, int nP) {
        FragmentNote fragment = new FragmentNote();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, (Parcelable) data);
        bundle.putInt("INT",nP);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.data = getArguments().getParcelable(ARG_NOTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        EditText message = view.findViewById(R.id.notes);
        TextView title = view.findViewById(R.id.nameNote);
        int i = getArguments().getInt("INT", 0);
        message.setText(data.getNoteData(i).getMessage());
        title.setText(data.getNoteData(i).getTitle());



//
//        title.setText(note.getTitle());
//        message.setText(note.getMessage());


        return view;
    }
}