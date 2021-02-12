package com.example.animeproject.api.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.animeproject.api.mappers.ResponseToAnimeListMapper;
import com.example.animeproject.api.services.AnimeService;
import com.example.animeproject.ui.adapters.DataGenerator;
import com.example.animeproject.ui.models.Anime;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

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
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jikan1.p.rapidapi.com/").build();
        AnimeService animeService = retrofit.create(AnimeService.class);

        Map<String, String> headers = new HashMap<>();
        headers.put("x-rapidapi-key", "e571cb2c3emshfde7189709c0589p11e602jsnd64518453519");
        headers.put("x-rapidapi-host", "jikan1.p.rapidapi.com");

        Call<List<Anime>> animes2 = animeService.listAnime(headers);

        try {
            Response<List<Anime>> animesResponse = animes2.execute();
            System.out.println(">>>>>>>>> " + animesResponse.body().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        MutableLiveData<List<Anime>> data = new MutableLiveData<>();
        data.setValue(animes);
        return data;
    }
}
