package org.jbtc.aniapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.jbtc.aniapp.model.Anime;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface AnimeDao {
    @Query("SELECT * FROM Anime")
    List<Anime> getAll();

    @Insert
    void insertAnime(Anime anime);
}
