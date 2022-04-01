package org.jbtc.aniapp.database.converter;

import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.List;

public class GenresConverter {
    List<String> genres= new ArrayList<>();
    @TypeConverter
    public List<String> toList(String genresS){
    if(genresS== null || genresS.isEmpty()){

        return genres;
    }

       return  genres;
    }
    @TypeConverter
    public  String toString(List<String>genres){
        String genresS="";
        if(genres==null){
            return  genresS;
        }

            return genresS;
    }

}
