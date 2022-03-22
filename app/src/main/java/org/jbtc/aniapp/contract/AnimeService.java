package org.jbtc.aniapp.contract;

import com.google.gson.JsonObject;

import org.jbtc.aniapp.model.RespuestaAnime;
import org.jbtc.aniapp.model.RespuestaAnimes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface AnimeService {

    @Headers({
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEzNTEiLCJuYmYiOjE2NDY4NzEyMzksImV4cCI6MTY0OTQ2MzIzOSwiaWF0IjoxNjQ2ODcxMjM5fQ.Y_ZjaJJOEi-Nk_Q_IqtoEC_Lf-mIxnCs-eOUu2ZhoYA",
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("v1/anime/{id}")
    Call<RespuestaAnime> getAnime(@Path("id") int id);

    @Headers({
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEzNTEiLCJuYmYiOjE2NDY4NzEyMzksImV4cCI6MTY0OTQ2MzIzOSwiaWF0IjoxNjQ2ODcxMjM5fQ.Y_ZjaJJOEi-Nk_Q_IqtoEC_Lf-mIxnCs-eOUu2ZhoYA",
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("v1/anime/")
    Call<RespuestaAnimes> getAnimes();


    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("v1/auth/me")
    Call<JsonObject> autenticacion(@Header("Authorization") String jwt);

}