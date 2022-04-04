package org.jbtc.aniapp.database.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ListStringJsonConverter {
    @TypeConverter
    public static String fromListstring(List<String> lista) {
        if(lista==null) return null;
        Gson g = new Gson();
        return g.toJson(lista);
    }

    @TypeConverter
    public static List<String> jsonToListstring(String lista) {
        Gson g = new Gson();
        return g.fromJson(lista, ArrayList.class);
    }
}
