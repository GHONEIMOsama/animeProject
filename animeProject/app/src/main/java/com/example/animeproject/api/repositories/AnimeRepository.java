package com.example.animeproject.api.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.animeproject.ui.adapters.DataGenerator;
import com.example.animeproject.ui.models.Anime;

import java.util.List;

public class AnimeRepository {

    private static AnimeRepository instance;
    private List<Anime> animes = DataGenerator.generateData();

    public static AnimeRepository getInstance() {
        if (instance == null) {
            instance = new AnimeRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Anime>> getAnimes() {
        MutableLiveData<List<Anime>> data = new MutableLiveData<>();
        data.setValue(animes);
        return data;
    }
}
