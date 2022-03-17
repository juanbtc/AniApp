package org.jbtc.aniapp.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Anime {
    private int id;
    private int anilist_id;
    private int mal_id;
    private int tmdb_id;
    private byte format;
    private byte status;
    private Titles titles;
    private Descriptions descriptions;
    private Date start_date;
    private Date end_date;
    private byte weekly_airing_day;
    private byte season_period;
    private int season_year;
    private int episodes_count;
    private int episode_duration;
    private String cover_image;
    private String cover_color;
    private String banner_image;
    private List<String> genres;
    private List<Sagas> sagas;
    private int sequel;
    private int prequel;
    private float score;
    private boolean nsfw;
    private String trailer_url;
    private boolean has_cover_image;

}