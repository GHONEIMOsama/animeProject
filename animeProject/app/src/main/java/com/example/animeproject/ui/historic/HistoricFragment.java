package com.example.animeproject.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.animeproject.R;
import com.example.animeproject.api.entities.AnimeEntity;
import com.example.animeproject.ui.adapters.HistoricRecyclerViewAdapter;
import com.example.animeproject.ui.adapters.RecyclerViewAdapter;
import com.example.animeproject.ui.home.HomeViewModel;
import com.example.animeproject.ui.models.Anime;

import java.util.List;

public class HistoricFragment extends Fragment {

    private RecyclerView recyclerView;
    private HistoricViewModel historicViewModel;
    private HistoricRecyclerViewAdapter historicRecyclerViewAdapter;

    public HistoricFragment() {}


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_historic, container, false);
        recyclerView = root.findViewById(R.id.recyclerview_historic);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        historicViewModel = new ViewModelProvider(this).get(HistoricViewModel.class);
        historicViewModel.init();
        historicViewModel.getAnimes().observe(getViewLifecycleOwner(), new Observer<List<AnimeEntity>>() {
            @Override
            public void onChanged(List<AnimeEntity> animes) {
                historicRecyclerViewAdapter.bindViewModels(animes);
            }
        });
        initRecyclerView();
    }

    private void initRecyclerView() {
        historicRecyclerViewAdapter = new HistoricRecyclerViewAdapter(requireContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(historicRecyclerViewAdapter);
    }
}