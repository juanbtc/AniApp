package org.jbtc.aniapp.contract;

import com.google.gson.JsonObject;

import org.jbtc.aniapp.model.RespuestaAnimes;
import org.jbtc.aniapp.model.RespuestaEpisode;
import org.jbtc.aniapp.model.RespuestaEpisodes;
import org.jbtc.aniapp.model.RespuestaSong;
import org.jbtc.aniapp.model.RespuestaSongs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SongService {

    @GET("v1/song/{id}")
    Call<RespuestaSong> getSong(@Path("id") int id);


    @GET("v1/song/?per_page="+10)
    Call<RespuestaSongs> getSongs(@Query("page") int page);

    @GET("v1/auth/me")
    Call<JsonObject> autenticacion(@Header("Authorization") String jwt);
}
