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
import retrofit2.http.Query;

public interface UserService {


    @GET("v1/user/{id}")
    Call<RespuestaUser> getUser(@Path("id") int id);


    @GET("v1/user/?per_page="+10)
    Call<RespuestaUsers> getUsers(@Query("page") int page);




    @GET("v1/auth/me")
    Call<JsonObject> autenticacion(@Header("Authorization") String jwt);

}
