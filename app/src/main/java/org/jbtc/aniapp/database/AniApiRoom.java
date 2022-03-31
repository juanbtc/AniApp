package org.jbtc.aniapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import org.jbtc.aniapp.R;
import org.jbtc.aniapp.database.converter.DateLongConverter;
import org.jbtc.aniapp.database.dao.AnimeDao;
import org.jbtc.aniapp.model.Anime;

@Database(entities = {Anime.class}, version = 1,exportSchema = false)
@TypeConverters({DateLongConverter.class})
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
