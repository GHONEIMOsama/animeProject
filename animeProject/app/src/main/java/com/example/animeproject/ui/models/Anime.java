package com.example.animeproject.ui.models;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Anime {

    private UUID id;
    private String title;
    private String image_url;
    private String synopsis;

    private Integer mal_id;
    private String url;
    private Boolean airing;
    private String type;
    private Integer episodes;
    private Double score;
    private String startDate;
    private String endDate;
    private Integer members;
    private String rated;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Anime(String title, String synopsis, String image_url) {
        this.title = title;
        this.image_url = image_url;
        this.synopsis = synopsis;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getMal_id() {
        return mal_id;
    }

    public void setMal_id(Integer mal_id) {
        this.mal_id = mal_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getAiring() {
        return airing;
    }

    public void setAiring(Boolean airing) {
        this.airing = airing;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", mal_id=" + mal_id +
                ", url='" + url + '\'' +
                ", airing=" + airing +
                ", type='" + type + '\'' +
                ", episodes=" + episodes +
                ", score=" + score +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", members=" + members +
                ", rated='" + rated + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
