package org.jbtc.aniapp.database.converter;

import androidx.room.TypeConverter;

import org.jbtc.aniapp.model.Descriptions;


public class DescriptionsConverter {
    Descriptions descriptions= new Descriptions();
    @TypeConverter
    public Descriptions toDescriptions(String descriptionsS){
        if(descriptionsS== null || descriptionsS.isEmpty())
        {
              return  descriptions;
        }

        return descriptions;
    }
    @TypeConverter
    public String toString(Descriptions descriptions){
        String  descriptionsS= "";
        if(descriptions  == null){
            return  descriptionsS;
        }
        return  descriptionsS;
    }
}
