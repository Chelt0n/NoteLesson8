package com.example.notelesson8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private NoteSource dataSource;
    private MyClickListener listener;
    private int nPosition;

    public int getnPosition() {
        return nPosition;
    }

    public void setMyClickListener(MyClickListener listener) {
        this.listener = listener;
    }


    public NoteAdapter(NoteSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleNote.setText(dataSource.getNoteData(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleNote;
        TextView dataNote;
        Button delBtn;


        public ViewHolder(View itemView) {
            super(itemView);
            titleNote = itemView.findViewById(R.id.titleNote);
            dataNote = itemView.findViewById(R.id.dataNote);
            delBtn = itemView.findViewById(R.id.delBtn);
            delBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nPosition = getAdapterPosition();
                    dataSource.deleteNoteData(nPosition);
                    notifyItemRemoved(nPosition);

                }
            });

            titleNote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onMyClick(v, getAdapterPosition());
                    nPosition = getAdapterPosition();
                }
            });
        }
    }
}
