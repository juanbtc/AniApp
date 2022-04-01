package org.jbtc.aniapp.contract;

import com.google.gson.JsonObject;

import org.jbtc.aniapp.model.RespuestaEpisode;
import org.jbtc.aniapp.model.RespuestaEpisodes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EpisodeService {

    @GET("v1/episode/{id}")
    Call<RespuestaEpisode> getEpisode(@Path("id") int id);

    //@GET("v1/episode?anime_id=3&is_dub=true&locale=it")
    @GET("v1/episode/?per_page="+10)
    Call<RespuestaEpisodes> getEpisodes(@Query("page") int page);
    @GET("v1/episode/?anime_id="+1+"&per_page="+10)
    Call<RespuestaEpisodes>getEpisodesByAnimeId(@Query("id") int id,@Query("page") int page);

    @GET("v1/auth/me")
    Call<JsonObject> autenticacion(@Header("Authorization") String jwt);
}
