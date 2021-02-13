package com.example.animeproject.api.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.animeproject.api.mappers.ResponseToAnimeListMapper;
import com.example.animeproject.api.services.AnimeService;
import com.example.animeproject.ui.adapters.DataGenerator;
import com.example.animeproject.ui.models.Anime;
import com.example.animeproject.ui.models.AnimeResponses;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeRepository {

    private static AnimeRepository instance;

    public static AnimeRepository getInstance() {
        if (instance == null) {
            instance = new AnimeRepository();
        }
        return instance;
    }

    public Single<AnimeResponses> getAnimes() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).addNetworkInterceptor(new StethoInterceptor()).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jikan1.p.rapidapi.com/").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(client)
                .build();
        AnimeService animeService = retrofit.create(AnimeService.class);

        return animeService.listAnime("Attack%20on%20Titan");
    }
}
