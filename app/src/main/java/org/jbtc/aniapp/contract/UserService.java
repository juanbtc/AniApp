package org.jbtc.aniapp.contract;

import com.google.gson.JsonObject;

import org.jbtc.aniapp.model.RespuestaAnime;
import org.jbtc.aniapp.model.RespuestaAnimes;
import org.jbtc.aniapp.model.RespuestaUser;
import org.jbtc.aniapp.model.RespuestaUsers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface UserService {

    @Headers({
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEzNTEiLCJuYmYiOjE2NDY4NzEyMzksImV4cCI6MTY0OTQ2MzIzOSwiaWF0IjoxNjQ2ODcxMjM5fQ.Y_ZjaJJOEi-Nk_Q_IqtoEC_Lf-mIxnCs-eOUu2ZhoYA",
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("v1/user/{id}")
    Call<RespuestaUser> getUser(@Path("id") int id);

    @Headers({
            "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEzNTEiLCJuYmYiOjE2NDY4NzEyMzksImV4cCI6MTY0OTQ2MzIzOSwiaWF0IjoxNjQ2ODcxMjM5fQ.Y_ZjaJJOEi-Nk_Q_IqtoEC_Lf-mIxnCs-eOUu2ZhoYA",
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @GET("v1/user/")
    Call<RespuestaUsers> getUsers();




    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })

    @GET("v1/auth/me")
    Call<JsonObject> autenticacion(@Header("Authorization") String jwt);

}
