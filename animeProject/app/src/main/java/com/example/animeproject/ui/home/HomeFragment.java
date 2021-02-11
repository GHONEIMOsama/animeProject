package com.example.animeproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animeproject.R;
import com.example.animeproject.ui.adapters.DataGenerator;
import com.example.animeproject.ui.adapters.RecyclerViewAdapter;
import com.example.animeproject.ui.models.Anime;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private Button change_button;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        recyclerView = root.findViewById(R.id.recyclerview_vertical);
        change_button = root.findViewById(R.id.change_button);
        initRecyclerView();
        initListeners();
        return root;
    }

    private void initRecyclerView() {
        recyclerViewAdapter = new RecyclerViewAdapter(DataGenerator.generateData(), requireContext());
        layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

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