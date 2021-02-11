package com.example.animeproject.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.animeproject.R;
import com.example.animeproject.ui.adapters.viewHolders.AnimeItemViewHolder;
import com.example.animeproject.ui.models.Anime;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<AnimeItemViewHolder> {

    private List<Anime> animes = new ArrayList<>();
    private Context context;


    public RecyclerViewAdapter(List<Anime> animes, Context context) {
        this.animes = animes;
        this.context = context;
    }

    @NonNull
    @Override
    public AnimeItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.anime_item, parent, false);
        AnimeItemViewHolder viewHolder = new AnimeItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeItemViewHolder holder, int position) {
        Glide.with(context).load(animes.get(position).getImageUrl()).error(R.mipmap.ic_launcher)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.getImage());
        holder.getTitle().setText(animes.get(position).getTitle());
        holder.getDescription().setText(animes.get(position).getDescription());
        holder.getParentLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, animes.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }
}
