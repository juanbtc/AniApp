package org.jbtc.aniapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
@Entity
public class Anime {
    @PrimaryKey(autoGenerate = true)
    public long id_anime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnilist_id() {
        return anilist_id;
    }

    public void setAnilist_id(int anilist_id) {
        this.anilist_id = anilist_id;
    }

    public int getMal_id() {
        return mal_id;
    }

    public void setMal_id(int mal_id) {
        this.mal_id = mal_id;
    }

    public int getTmdb_id() {
        return tmdb_id;
    }

    public void setTmdb_id(int tmdb_id) {
        this.tmdb_id = tmdb_id;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }



    public byte getWeekly_airing_day() {
        return weekly_airing_day;
    }

    public void setWeekly_airing_day(byte weekly_airing_day) {
        this.weekly_airing_day = weekly_airing_day;
    }

    public byte getSeason_period() {
        return season_period;
    }

    public void setSeason_period(byte season_period) {
        this.season_period = season_period;
    }

    public int getSeason_year() {
        return season_year;
    }

    public void setSeason_year(int season_year) {
        this.season_year = season_year;
    }

    public int getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(int episodes_count) {
        this.episodes_count = episodes_count;
    }

    public int getEpisode_duration() {
        return episode_duration;
    }

    public void setEpisode_duration(int episode_duration) {
        this.episode_duration = episode_duration;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getCover_color() {
        return cover_color;
    }

    public void setCover_color(String cover_color) {
        this.cover_color = cover_color;
    }

    public String getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(String banner_image) {
        this.banner_image = banner_image;
    }

    public int getSequel() {
        return sequel;
    }

    public void setSequel(int sequel) {
        this.sequel = sequel;
    }

    public int getPrequel() {
        return prequel;
    }

    public void setPrequel(int prequel) {
        this.prequel = prequel;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

    public String getTrailer_url() {
        return trailer_url;
    }

    public void setTrailer_url(String trailer_url) {
        this.trailer_url = trailer_url;
    }

    public boolean isHas_cover_image() {
        return has_cover_image;
    }

    public void setHas_cover_image(boolean has_cover_image) {
        this.has_cover_image = has_cover_image;
    }

    private int id;
    private int anilist_id;
    private int mal_id;
    private int tmdb_id;
    private byte format;
    private byte status;
    private Titles titles;
    //private Descriptions descriptions;
    public long descriptions_id;
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

    public String getFormatToString() {
        switch (format){
            case 0: return "TV";
            case 1: return "TV_SHORT";
            case 2: return "MOVIE";
            case 3: return "SPECIAL";
            case 4: return "OVA";
            case 5: return "ONA";
            case 6: return "MUSIC";
            default: return "NULL";
        }
    }

    public String getWeekly_airing_dayToString() {
        switch (format){
            case 0: return "Sunday";
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
            default: return "NULL";
        }
    }

    public String getStatusToString() {
        switch (format){
            case 0: return "FINISHED";
            case 1: return "RELEASING";
            case 2: return "NOT_YET_RELEASED";
            case 3: return "CANCELLED";
            default: return "NULL";
        }
    }
}
