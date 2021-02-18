package com.example.animeproject.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.animeproject.R;

public class DashboardFragment extends Fragment {


    private String title;
    private String imageUrl;
    private String synopsis;

    private TextView titleTextView;
    private ImageView imageView;
    private TextView synopsisTextView;

    public DashboardFragment() {}

    public DashboardFragment(String title, String imageUrl, String synopsis) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.synopsis = synopsis;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_details, container, false);
        titleTextView = root.findViewById(R.id.details_title);
        imageView = root.findViewById(R.id.details_image);
        synopsisTextView = root.findViewById(R.id.details_synopsis);
        titleTextView.setText(title);
        Glide.with(requireContext()).load(imageUrl).error(R.mipmap.ic_launcher)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
        synopsisTextView.setText(synopsis);
        return root;
    }
}