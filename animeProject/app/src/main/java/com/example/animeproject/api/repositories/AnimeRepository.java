package com.example.animeproject.api.repositories;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.example.animeproject.api.db.AnimeDatabase;
import com.example.animeproject.api.entities.AnimeEntity;
import com.example.animeproject.api.services.AnimeService;
import com.example.animeproject.ui.models.AnimeResponses;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeRepository {

    private static AnimeRepository instance;
    private static AnimeDatabase animeDatabase;
    private static Context context;

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

    public void storeAnime(AnimeEntity animeEntity) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // Insert Data
                animeDatabase.animeDao().insertAll(animeEntity);
            }
        });
    }

    public Single<List<AnimeEntity>> getAllAnimes() {
        return animeDatabase.animeDao().getAll();
    }

    public static void setContext(Context appContext) {
        context = appContext;
        initDatabase();
    }

    private static void initDatabase() {
        if (animeDatabase == null) {
            animeDatabase = Room.databaseBuilder(context, AnimeDatabase.class, "anime-database").build();
        }
    }
}
