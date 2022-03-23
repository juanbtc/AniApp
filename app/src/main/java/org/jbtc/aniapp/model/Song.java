package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class Song {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(int anime_id) {
        this.anime_id = anime_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public String getOpen_spotify_url() {
        return open_spotify_url;
    }

    public void setOpen_spotify_url(String open_spotify_url) {
        this.open_spotify_url = open_spotify_url;
    }

    public String getLocal_spotify_url() {
        return local_spotify_url;
    }

    public void setLocal_spotify_url(String local_spotify_url) {
        this.local_spotify_url = local_spotify_url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private int id;
    private int anime_id;
    private String title;
    private String artist;
    private String album;
    private int year;
    private int season;
    private int duration;
    private String preview_url;
    private String open_spotify_url;
    private String local_spotify_url;
    private int type;

}
