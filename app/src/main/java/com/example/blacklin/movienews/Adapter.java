package com.example.blacklin.movienews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private List<Origin> listMovies;

    public Adapter(Context context, List<Origin> listMovies){
        this.context = context;
        this.listMovies = listMovies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, null, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Origin origin = listMovies.get(position);
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w185"+ origin.getPosterPath())
                .placeholder(R.drawable.img_default_bg)
                .into(holder.gmb);
        holder.judul.setText(origin.getTitle());
        holder.desc.setText(origin.getOverview());
        holder.data.setText(origin.getReleaseDate());
//-

        holder.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("title", origin.getTitle());
                i.putExtra("poster_path", origin.getPosterPath());
                i.putExtra("overview", origin.getOverview());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Button btnSelect;
        private ImageView gmb;
        private TextView judul, desc, data;
        public ViewHolder(View itemView) {
            super(itemView);
            btnSelect = itemView.findViewById(R.id.btnSelect);
            gmb = itemView.findViewById(R.id.poster_utama);
            judul = itemView.findViewById(R.id.judul_utama);
            desc = itemView.findViewById(R.id.deskripsi_utama);
            data = itemView.findViewById(R.id.realease_utama);
        }
    }
}

