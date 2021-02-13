package com.example.animeproject.api.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.animeproject.api.mappers.ResponseToAnimeListMapper;
import com.example.animeproject.api.services.AnimeService;
import com.example.animeproject.ui.adapters.DataGenerator;
import com.example.animeproject.ui.models.Anime;
import com.example.animeproject.ui.models.AnimeResponses;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeRepository {

    private static AnimeRepository instance;
    private List<Anime> animes = DataGenerator.generateData();
    private ResponseToAnimeListMapper responseToAnimeListMapper = new ResponseToAnimeListMapper();

    public static AnimeRepository getInstance() {
        if (instance == null) {
            instance = new AnimeRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Anime>> getAnimes() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jikan1.p.rapidapi.com/").addConverterFactory(GsonConverterFactory.create())
                .build();
        AnimeService animeService = retrofit.create(AnimeService.class);

        Call<AnimeResponses> animesCall = animeService.listAnime("Attack%20on%20Titan");
        animesCall.enqueue(new Callback<AnimeResponses>() {
            @Override
            public void onResponse(Call<AnimeResponses> call, Response<AnimeResponses> response) {
                System.out.println(response.body().getResults().toString());
            }

            @Override
            public void onFailure(Call<AnimeResponses> call, Throwable t) {
                t.printStackTrace();
            }
        });


        MutableLiveData<List<Anime>> data = new MutableLiveData<>();
        data.setValue(animes);
        return data;
    }
}
