package org.jbtc.aniapp.database.converter;

import androidx.room.TypeConverter;

import org.jbtc.aniapp.model.Titles;

public class TitlesConverter {
    Titles titles= new Titles();
    @TypeConverter
    public  Titles toTitles(String titlesS){
        if(titlesS== null || titlesS.isEmpty())
        {
            return titles;
        }

        return titles;
    }
    @TypeConverter
    public String toString(Titles titles){
        String  titlesS= "";
          if(titles  == null){
              return  titlesS;
          }
          return  titlesS;
     }

}
