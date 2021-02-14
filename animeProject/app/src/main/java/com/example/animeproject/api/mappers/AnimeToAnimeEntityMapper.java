package com.example.animeproject.api.mappers;

import com.example.animeproject.ui.models.Anime;

import java.util.List;

import okhttp3.Response;

public class ResponseToAnimeListMapper {

    public List<Anime> map(Response response) {
        System.out.println(">>>>>>> " + response.body().toString());
        return null;
    }
}
