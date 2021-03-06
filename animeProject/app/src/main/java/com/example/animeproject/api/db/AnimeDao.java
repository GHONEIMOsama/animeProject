package com.example.animeproject.api.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.animeproject.api.entities.AnimeEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface AnimeDao {

    @Query("SELECT * FROM AnimeEntity ORDER BY datetime(date_col) DESC")
    Single<List<AnimeEntity>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(AnimeEntity... animeEntities);

}
