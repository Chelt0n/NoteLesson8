package com.example.notelesson8;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentTitleNote extends Fragment implements MyClickListener {
    NoteSource data;
    RecyclerView recyclerView;
    NoteAdapter adapter;
    Bundle bundle;

    public static FragmentTitleNote newInstance() {
        return new FragmentTitleNote();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title_note, container, false);
        setHasOptionsMenu(true);

        data = new NoteSourceImpl(getResources()).init();


        recyclerView = view.findViewById(R.id.recyclerView);

        adapter = new NoteAdapter(data);
        adapter.setMyClickListener(this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onMyClick(View view, int position) {
        bundle = new Bundle();
        bundle.putInt("INT", position);
        showNoteFragment();
        Toast.makeText(getContext(), "выполнил " + position, Toast.LENGTH_SHORT).show();
    }

    private void showNoteFragment() {
        int layoutId = R.id.fragment_container;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutId = R.id.fragment_container_note;
        }

        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(layoutId, FragmentNote.newInstance(data, bundle.getInt("INT")))
                .addToBackStack("").commit();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.item_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemAdd:
                data.addNoteData(new NoteData("тест", "сообщение"));
                adapter.notifyItemInserted(data.size());
                return true;
            case R.id.menuItemClear:
                data.clearNoteData();
                adapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}
