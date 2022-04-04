package org.jbtc.aniapp.database.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import org.jbtc.aniapp.model.Sagas;

import java.util.ArrayList;
import java.util.List;

public class ListaSagasJsonConverter {
    @TypeConverter
    public static String fromListsagas(List<Sagas> sagas) {
        if(sagas==null) return null;
        Gson g = new Gson();
        return g.toJson(sagas);
    }

    @TypeConverter
    public static List<Sagas> jsonToListsagas(String sagas) {
        Gson g = new Gson();
        return g.fromJson(sagas, ArrayList.class);
    }
}
