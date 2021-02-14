package com.example.animeproject.api.mappers;

import com.example.animeproject.api.entities.AnimeEntity;
import com.example.animeproject.ui.models.Anime;

import java.util.List;

import okhttp3.Response;

public class AnimeToAnimeEntityMapper {

    public AnimeEntity map(Anime anime) {
        AnimeEntity animeEntity = new AnimeEntity();
        animeEntity.setImageUrl(anime.getImage_url());
        animeEntity.setTitle(anime.getTitle());
        return animeEntity;
    }
}
