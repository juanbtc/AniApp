package org.jbtc.aniapp.database.converter;

import androidx.room.TypeConverter;

import org.jbtc.aniapp.model.Sagas;

import java.util.ArrayList;
import java.util.List;

public class SagasConverter {
    List<Sagas> sagas= new ArrayList<>();
    @TypeConverter
    public List<Sagas> toList(String sagasS){
        if(sagasS== null || sagasS.isEmpty()){

            return sagas;
        }

        return  sagas;
    }
    @TypeConverter
    public  String toString(List<Sagas>sagas){
        String sagasS="";
        if(sagas==null){
            return  sagasS;
        }

        return sagasS;
    }
}
