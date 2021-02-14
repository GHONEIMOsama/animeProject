package com.example.animeproject.api.repositories;

import com.example.animeproject.api.services.AnimeService;
import com.example.animeproject.ui.models.AnimeResponses;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
