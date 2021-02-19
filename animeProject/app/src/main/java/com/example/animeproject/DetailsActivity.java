package com.example.animeproject;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.animeproject.api.db.AnimeDao;
import com.example.animeproject.api.db.AnimeDatabase;
import com.example.animeproject.api.entities.AnimeEntity;
import com.example.animeproject.api.repositories.AnimeRepository;

import java.util.Calendar;
import java.util.Date;

public class DetailsActivity extends AppCompatActivity {

    private static AnimeDatabase animeDatabase;
    private AnimeRepository animeRepository = AnimeRepository.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String title = getIntent().getStringExtra("title");
        String imageUrl = getIntent().getStringExtra("image_url");
        String synopsis = getIntent().getStringExtra("synopsis");
        Integer malId = Integer.parseInt(getIntent().getStringExtra("mal_id"), 10);


        AnimeEntity animeEntity = new AnimeEntity();
        animeEntity.setTitle(title);
        animeEntity.setImageUrl(imageUrl);
        Date currentTime = Calendar.getInstance().getTime();
        DateFormat dateFormat = new DateFormat();
        animeEntity.setDate(dateFormat.format("yyyy-MM-dd hh:mm:ss", currentTime).toString());

        animeRepository.storeAnime(animeEntity);


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
