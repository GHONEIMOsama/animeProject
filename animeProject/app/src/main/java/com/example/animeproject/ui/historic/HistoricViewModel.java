package com.example.animeproject.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.animeproject.api.entities.AnimeEntity;
import com.example.animeproject.api.repositories.AnimeRepository;
import com.example.animeproject.ui.models.Anime;
import com.example.animeproject.ui.models.AnimeResponses;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HistoricViewModel extends ViewModel {

    private MutableLiveData<List<AnimeEntity>> animes;
    private AnimeRepository animeRepository;

    public void init() {
        if (animes != null) {
            return;
        }
        animeRepository = AnimeRepository.getInstance();
    }

    public LiveData<List<AnimeEntity>> getAnimes() {
        if (animes == null) {
            animes = new MutableLiveData<>();
            animes.setValue(animeRepository.getAllAnimes());
        }
        return animes;
    }
}