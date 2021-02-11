package com.example.animeproject.ui.models;

import java.util.UUID;

public class Anime {

    private UUID id;
    private String title;
    private String imageUrl;
    private String description;

    public Anime(String title, String description, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
