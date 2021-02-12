package com.example.animeproject.api.services;

import com.example.animeproject.ui.models.Anime;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;

public interface AnimeService {

    @GET("anime/16498/episodes")
    Call<List<Anime>> listAnime(@HeaderMap Map<String, String> headers);

}
