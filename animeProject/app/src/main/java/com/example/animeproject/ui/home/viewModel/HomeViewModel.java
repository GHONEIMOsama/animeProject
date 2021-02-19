package com.example.animeproject.ui.home.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.animeproject.api.repositories.AnimeRepository;
import com.example.animeproject.ui.models.Anime;
import com.example.animeproject.ui.models.AnimeResponses;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Anime>> animes;
    private AnimeRepository animeRepository;
    private CompositeDisposable compositeDisposable;

    /**
     * Initialize the viewModel fields
     */
    public void init() {
        if (animes != null) {
            return;
        }
        animeRepository = AnimeRepository.getInstance();
        compositeDisposable = new CompositeDisposable();
    }

    /**
     * A method to get the animes after calling an external api
     * @return a lifeData object containing a list of Anime objects fetched from the public api using the repository
     */
    public LiveData<List<Anime>> getAnimes() {
        if (animes == null) {
            animes = new MutableLiveData<>();
            compositeDisposable.add(animeRepository.getAnimes().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSingleObserver<AnimeResponses>() {
                        @Override
                        public void onSuccess(@NonNull AnimeResponses animeResponses) {
                            animes.setValue(animeResponses.getResults());
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