package com.example.animeproject.ui.historic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.animeproject.api.entities.AnimeEntity;
import com.example.animeproject.api.repositories.AnimeRepository;
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
    private CompositeDisposable compositeDisposable;


    public void init() {
        if (animes != null) {
            return;
        }
        animeRepository = AnimeRepository.getInstance();
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<List<AnimeEntity>> getAnimes() {
        if (animes == null) {
            animes = new MutableLiveData<>();
            compositeDisposable.add(animeRepository.getAllAnimes().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSingleObserver<List<AnimeEntity>>() {
                        @Override
                        public void onSuccess(@NonNull List<AnimeEntity> animeEntities) {
                            animes.setValue(animeEntities);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            e.printStackTrace();
                        }
                    }));
        }
        return animes;
    }
}