package com.example.animeproject.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.animeproject.MainActivity;
import com.example.animeproject.R;
import com.example.animeproject.ui.adapters.viewHolders.AnimeItemViewHolder;
import com.example.animeproject.ui.dashboard.DashboardFragment;
import com.example.animeproject.ui.models.Anime;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<AnimeItemViewHolder> {

    private List<Anime> animes = new ArrayList<>();
    private Context context;
    private FragmentManager fragmentManager;


    public RecyclerViewAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
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
        Anime anime = animes.get(position);
        Glide.with(context).load(anime.getImage_url()).error(R.mipmap.ic_launcher)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.getImage());
        holder.getTitle().setText(anime.getTitle());
        holder.getSynopsis().setText(anime.getSynopsis());
        holder.getParentLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, new DashboardFragment(anime.getTitle(), anime.getImage_url(), anime.getSynopsis()));
                fragmentTransaction.commit();
                Toast.makeText(context, anime.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public void bindViewModels(List<Anime> animes) {
        this.animes.clear();
        this.animes.addAll(animes);
        notifyDataSetChanged();
    }
}
