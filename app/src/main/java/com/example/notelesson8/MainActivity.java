package com.example.notelesson8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NoteSource data = new NoteSourceImpl(getResources()).init();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, FragmentTitleNote.newInstance())
                .commit();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_note, FragmentNote.newInstance(data, 2)).commit();
        }
    }

}