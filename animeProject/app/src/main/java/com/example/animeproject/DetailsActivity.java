package com.example.animeproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final TextView titleTextView = findViewById(R.id.details_title);
        titleTextView.setText(getIntent().getStringExtra("title"));
        final ImageView imageView = findViewById(R.id.details_image);
        Glide.with(this).load(getIntent().getStringExtra("image_url")).error(R.mipmap.ic_launcher)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
        final TextView synopsisTextView = findViewById(R.id.details_synopsis);
        synopsisTextView.setText(getIntent().getStringExtra("synopsis"));
    }
}
