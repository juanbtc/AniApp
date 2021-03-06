package org.jbtc.aniapp.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import org.jbtc.aniapp.database.entity.DescriptionsAndAnime;
import org.jbtc.aniapp.model.Anime;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface AnimeDao {
    //  CRUD

    //  CREATE
    @Insert
    Single<Long> insertAnime(Anime anime);
    @Insert
    Single<long[]> insertAnimes(List<Anime> animes);
    /*@Transaction
    @Query("SELECT * FROM Pedido where id=:id;")
    Single<PedidoConCarrito> getPedidoConCarrito(long id);*/

    // READ
    @Query("select * from Anime where id=:id")
    Single<Anime> getAnimeById(int id);
    @Query("select * from Anime")
    Single<List<Anime>> getAnimes();
    @Query("select * from Anime")
    Observable<List<Anime>> getAnimesObs();

    @Query("select * from Anime where favorite=1")
    Single<List<Anime>> getAnimesFavoritos();

    //  UPDATE
    @Update
    Single<Integer> updateAnime(Anime anime);

    //  DELETE
    @Delete
    Single<Integer> deleteAnime(Anime anime);
    @Query("delete from Anime")
    Single<Integer> clearAnime();

    @Transaction
    @Query("SELECT * FROM Descriptions")
    public Single<List<DescriptionsAndAnime>> getDescriptionsAndAnime();
}
