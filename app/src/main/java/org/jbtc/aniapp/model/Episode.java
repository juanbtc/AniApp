package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class Episode {
    private int id;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Boolean getIs_dub() {
        return is_dub;
    }

    public void setIs_dub(Boolean is_dub) {
        this.is_dub = is_dub;
    }

    private int anime_id;
    private int number;
    private String title;
    private String video;
    private  String locale;
    private  int quality;
    private  String format;
    private  Boolean is_dub;

}
