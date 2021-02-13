package com.example.animeproject.api.services;

import com.example.animeproject.ui.models.Anime;
import com.example.animeproject.ui.models.AnimeResponses;

import java.util.List;
import java.util.Map;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface AnimeService {

    @Headers({
            "x-rapidapi-key:e571cb2c3emshfde7189709c0589p11e602jsnd64518453519",
            "x-rapidapi-host:jikan1.p.rapidapi.com"
    })
    @GET("search/anime")
    Single<AnimeResponses> listAnime(@Query("q") String q);

}
