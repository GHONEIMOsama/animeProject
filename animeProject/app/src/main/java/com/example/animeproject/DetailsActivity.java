package com.example.animeproject;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.animeproject.api.db.AnimeDao;
import com.example.animeproject.api.db.AnimeDatabase;
import com.example.animeproject.api.entities.AnimeEntity;

public class DetailsActivity extends AppCompatActivity {

    private static AnimeDatabase animeDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String title = getIntent().getStringExtra("title");
        String imageUrl = getIntent().getStringExtra("image_url");
        String synopsis = getIntent().getStringExtra("synopsis");

        AnimeEntity animeEntity = new AnimeEntity();
        animeEntity.setTitle(title);
        animeEntity.setImageUrl(imageUrl);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // Insert Data
                getAnimeDatabase(getApplicationContext()).animeDao().insertAll(animeEntity);
            }
        });

        /*AnimeDatabase animeDatabase = getAnimeDatabase(getApplicationContext());
        AnimeDao animeDao = animeDatabase.animeDao();


        animeDao.insertAll(animeEntity);*/


        final TextView titleTextView = findViewById(R.id.details_title);
        titleTextView.setText(title);
        final ImageView imageView = findViewById(R.id.details_image);
        Glide.with(this).load(imageUrl).error(R.mipmap.ic_launcher)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
        final TextView synopsisTextView = findViewById(R.id.details_synopsis);
        synopsisTextView.setText(synopsis);
    }

    public static AnimeDatabase getAnimeDatabase(Context context) {
        if (animeDatabase == null) {
            animeDatabase = Room.databaseBuilder(context, AnimeDatabase.class, "anime-database").build();
        }
        return animeDatabase;
    }
}
