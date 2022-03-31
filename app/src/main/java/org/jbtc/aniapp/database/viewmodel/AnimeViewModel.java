package org.jbtc.aniapp.database.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import org.jbtc.aniapp.database.AniApiRoom;
import org.jbtc.aniapp.database.dao.AnimeDao;
import org.jbtc.aniapp.model.Anime;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AnimeViewModel extends AndroidViewModel {
    private AnimeDao animeDao;

    public AnimeViewModel(@NonNull Application application) {
        super(application);
        animeDao = AniApiRoom.getInstance(application).animeDao();
    }

    public Single<long[]> insertAnimes(List<Anime> animes){
        return animeDao.insertAnimes(animes)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Long> insertAnime(Anime anime){
        return animeDao.insertAnime(anime)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Anime> getAnimeById(int id){
        return animeDao.getAnimeById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<Anime>> getAnimes(){
        return animeDao.getAnimes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public Observable<List<Anime>> getAnimesObs(){
        return animeDao.getAnimesObs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Integer> updateAnime(Anime anime){
        return animeDao.updateAnime(anime)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Integer> deleteAnime(Anime anime){
        return animeDao.deleteAnime(anime)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
