package org.jbtc.aniapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import org.jbtc.aniapp.R;

import org.jbtc.aniapp.database.converter.DescriptionsConverter;
import org.jbtc.aniapp.database.converter.ListStringJsonConverter;
import org.jbtc.aniapp.database.converter.ListaSagasJsonConverter;
import org.jbtc.aniapp.database.converter.TitlesJsonConverter;
import org.jbtc.aniapp.model.Descriptions;
import org.jbtc.aniapp.model.Titles;
import org.jbtc.aniapp.database.converter.GenresConverter;
import org.jbtc.aniapp.database.converter.SagasConverter;
import org.jbtc.aniapp.database.converter.TitlesConverter;
import org.jbtc.aniapp.database.dao.AnimeDao;
import org.jbtc.aniapp.database.converter.DateLongConverter;

import org.jbtc.aniapp.model.Anime;

/*@TypeConverters({DateLongConverter.class,
                 TitlesConverter.class,
                 DescriptionsConverter.class,
                 GenresConverter.class,
                 SagasConverter.class})*/

//@Database(entities = {Anime.class}, version = 1,exportSchema = false)
@Database(entities = {Anime.class, Descriptions.class}, version = 1,exportSchema = false)
@TypeConverters({
        DateLongConverter.class,
        TitlesJsonConverter.class,
        ListStringJsonConverter.class,
        ListaSagasJsonConverter.class
})
public abstract class AniApiRoom extends RoomDatabase {


    private static volatile AniApiRoom INSTANCE;

    public static AniApiRoom getInstance(Context contexto){
        if(INSTANCE==null){
            synchronized (AniApiRoom.class){
                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(contexto.getApplicationContext(),
                            AniApiRoom.class,contexto.getResources().getString(R.string.dabase_name))
                            //.allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract AnimeDao animeDao();
}
