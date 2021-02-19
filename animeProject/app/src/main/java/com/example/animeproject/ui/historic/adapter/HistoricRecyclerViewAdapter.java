package com.example.animeproject.ui.historic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.animeproject.R;
import com.example.animeproject.api.entities.AnimeEntity;
import com.example.animeproject.ui.historic.adapter.viewHolder.HistoricAnimeItemViewHolder;

import java.util.ArrayList;
import java.util.List;

public class HistoricRecyclerViewAdapter extends RecyclerView.Adapter<HistoricAnimeItemViewHolder> {

    private List<AnimeEntity> animes = new ArrayList<>();
    private Context context;


    public HistoricRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HistoricAnimeItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.historic_anime_item, parent, false);
        HistoricAnimeItemViewHolder viewHolder = new HistoricAnimeItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricAnimeItemViewHolder holder, int position) {
        AnimeEntity anime = animes.get(position);
        Glide.with(context).load(anime.getImageUrl()).error(R.mipmap.ic_launcher).dontAnimate()
                .centerCrop()
                .into(holder.getImage());
        holder.getTitle().setText(anime.getTitle());
        holder.getDate().setText(anime.getDate());
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public void bindViewModels(List<AnimeEntity> animes) {
        this.animes.clear();
        this.animes.addAll(animes);
        notifyDataSetChanged();
    }
}
