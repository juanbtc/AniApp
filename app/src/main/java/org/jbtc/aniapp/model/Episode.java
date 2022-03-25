package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class Episode {
    private int id;
    private int anime_id;
    private int number;
    private String title;
    private String video;
    private  String locale;
    private  int quality;
    private  String format;
    private  Boolean is_dub;

}
