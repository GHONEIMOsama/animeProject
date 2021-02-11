package com.example.animeproject.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.animeproject.api.repositories.AnimeRepository;
import com.example.animeproject.ui.models.Anime;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Anime>> animes;
    private AnimeRepository animeRepository;

    public void init() {
        if (animes != null) {
            return;
        }
        animeRepository = AnimeRepository.getInstance();
        animes = animeRepository.getAnimes();
    }

    public LiveData<List<Anime>> getAnimes() {
        return animes;
    }
}