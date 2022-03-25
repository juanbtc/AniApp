package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class Song {
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
