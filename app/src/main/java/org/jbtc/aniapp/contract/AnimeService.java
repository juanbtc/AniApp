package org.jbtc.aniapp.contract;

import com.google.gson.JsonObject;

import org.jbtc.aniapp.model.RespuestaAnime;
import org.jbtc.aniapp.model.RespuestaAnimes;

import org.jbtc.aniapp.model.RespuestaEpisode;
import org.jbtc.aniapp.model.RespuestaEpisodes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AnimeService {
    /**
     * Retorna un anime mediante el id
     */
    @GET("v1/anime/{id}")
    Call<RespuestaAnime> getAnime(@Path("id") int id);


    @GET("v1/anime/?per_page="+10)
    Call<RespuestaAnimes> getAnimes(@Query("page") int page);

    @GET("v1/auth/me")
    Call<JsonObject> autenticacion(@Header("Authorization") String jwt);

}