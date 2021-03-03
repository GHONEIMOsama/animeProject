package com.example.animeproject.ui.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animeproject.R;
import com.example.animeproject.ui.home.adapter.RecyclerViewAdapter;
import com.example.animeproject.ui.home.viewModel.HomeViewModel;
import com.example.animeproject.ui.models.Anime;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private Button change_button;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.recyclerview_vertical);
        change_button = root.findViewById(R.id.change_button);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.init();
        // Sending the data to the recyclerview's adapter after receiving it from public api
        homeViewModel.getAnimes().observe(getViewLifecycleOwner(), new Observer<List<Anime>>() {
            @Override
            public void onChanged(List<Anime> animes) {
                recyclerViewAdapter.bindViewModels(animes);
            }
        });
        initRecyclerView();
        initListeners();
    }

    /**
     * Inialize the recyclerView
     */
    private void initRecyclerView() {
        recyclerViewAdapter = new RecyclerViewAdapter(requireContext(), getParentFragmentManager());
        layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * used to set listeners.
     * set a listener on the button to change layout manager.
     */
    private void initListeners() {
        change_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutManager instanceof GridLayoutManager) {
                    layoutManager = new LinearLayoutManager(requireContext());
                    change_button.setText("Grid View");
                } else {
                    layoutManager = new GridLayoutManager(requireContext(), 2);
                    change_button.setText("List View");
                }
                recyclerView.setLayoutManager(layoutManager);
            }
        });
    }
}