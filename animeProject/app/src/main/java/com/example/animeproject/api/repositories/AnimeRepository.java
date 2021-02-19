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

    /**
     * A method implement to apply the singleton design pattern.
     * @return an AnimeRepository object
     */
    public static AnimeRepository getInstance() {
        if (instance == null) {
            instance = new AnimeRepository();
        }
        return instance;
    }

    /**
     * A method used to call public api to retreive data from it.
     * @return a Single object of AnimeResponses object containing the data fetched from the public api
     */
    public Single<AnimeResponses> getAnimes() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).addNetworkInterceptor(new StethoInterceptor()).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jikan1.p.rapidapi.com/").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(client)
                .build();
        AnimeService animeService = retrofit.create(AnimeService.class);

        return animeService.listAnime("Attack%20on%20Titan");
    }

    /**
     * used to store an AnimeEntity in the local database.
     * @param animeEntity an AnimeEntity object to be stored in the local database.
     */
    public void storeAnime(AnimeEntity animeEntity) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // Insert Data
                animeDatabase.animeDao().insertAll(animeEntity);
            }
        });
    }

    /**
     * used to fetch all AnimeEntities object from local database.
     * @return a Single object of List of AnimeEntity objects representing all AnimeEntities stored in the local database.
     */
    public Single<List<AnimeEntity>> getAllAnimes() {
        return animeDatabase.animeDao().getAll();
    }

    /**
     * A method used to init the context and the database.
     * @param appContext the application context of the app.
     */
    public static void setContext(Context appContext) {
        context = appContext;
        initDatabase();
    }

    /**
     * used to initialize the database.
     */
    private static void initDatabase() {
        if (animeDatabase == null) {
            animeDatabase = Room.databaseBuilder(context, AnimeDatabase.class, "anime-database").build();
        }
    }
}
