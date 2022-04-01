package org.jbtc.aniapp.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import org.jbtc.aniapp.database.converter.DescriptionsConverter;
import org.jbtc.aniapp.database.converter.GenresConverter;
import org.jbtc.aniapp.database.converter.SagasConverter;
import org.jbtc.aniapp.database.converter.TitlesConverter;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
@Entity
public class Anime {
    @PrimaryKey(autoGenerate = true)
    public long id_anime;
    private int id;
    private int anilist_id;
    private int mal_id;
    private int tmdb_id;
    private byte format;
    private byte status;
    @TypeConverters(TitlesConverter.class)
    private Titles titles;
    @TypeConverters(DescriptionsConverter.class)
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
    @TypeConverters(GenresConverter.class)
    private List<String> genres;
    @TypeConverters(SagasConverter.class)
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