package com.example.animeproject.api.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.animeproject.api.entities.AnimeEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface AnimeDao {

    @Query("SELECT * FROM AnimeEntity")
    Single<List<AnimeEntity>> getAll();

    @Insert
    void insertAll(AnimeEntity... animeEntities);
}
