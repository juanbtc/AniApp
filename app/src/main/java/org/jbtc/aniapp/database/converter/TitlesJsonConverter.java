package org.jbtc.aniapp.database.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import org.jbtc.aniapp.model.Titles;

public class TitlesJsonConverter {
    @TypeConverter
    public static String fromListsagas(Titles titles) {
        if(titles==null) return null;
        Gson g = new Gson();
        return g.toJson(titles);
    }

    @TypeConverter
    public static Titles jsonToListsagas(String titles) {
        Gson g = new Gson();
        return g.fromJson(titles, Titles.class);
    }
}
