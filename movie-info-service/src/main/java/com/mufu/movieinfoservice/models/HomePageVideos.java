package com.mufu.movieinfoservice.models;

public class HomePageVideos {
    private String id;
    private String title;
    private String genres;
    private String embed_id;
    private String thumbnail;

    public HomePageVideos() {
    }

    public HomePageVideos(String id, String title, String genres, String embed_id, String thumbnail) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.embed_id = embed_id;
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getEmbed_id() {
        return embed_id;
    }

    public void setEmbed_id(String embed_id) {
        this.embed_id = embed_id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
