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

public interface SongService {
    @Headers({
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEzNTEiLCJuYmYiOjE2NDY4NzEyMzksImV4cCI6MTY0OTQ2MzIzOSwiaWF0IjoxNjQ2ODcxMjM5fQ.Y_ZjaJJOEi-Nk_Q_IqtoEC_Lf-mIxnCs-eOUu2ZhoYA",
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("v1/song/{id}")
    Call<RespuestaSong> getSong(@Path("id") int id);

    @Headers({
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEzNTEiLCJuYmYiOjE2NDY4NzEyMzksImV4cCI6MTY0OTQ2MzIzOSwiaWF0IjoxNjQ2ODcxMjM5fQ.Y_ZjaJJOEi-Nk_Q_IqtoEC_Lf-mIxnCs-eOUu2ZhoYA",
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("v1/song/")
    Call<RespuestaSongs> getSongs();
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })

    @GET("v1/auth/me")
    Call<JsonObject> autenticacion(@Header("Authorization") String jwt);
}
