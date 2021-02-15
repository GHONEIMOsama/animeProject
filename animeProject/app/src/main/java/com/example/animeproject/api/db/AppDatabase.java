package com.example.animeproject.api.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.animeproject.api.entities.AnimeEntity;

@Database(entities = {AnimeEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AnimeDao animeDao();
}
