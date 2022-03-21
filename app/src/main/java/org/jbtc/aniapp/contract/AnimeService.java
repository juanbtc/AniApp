package org.jbtc.aniapp.contract;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface AnimeService {
    //@GET("users/{user}/repos")
    //Call<Respuesta> listRepos();

    @Headers({
        "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEyMDciLCJuYmYiOjE2NDc4Nzg5NjgsImV4cCI6MTY1MDQ3MDk2OCwiaWF0IjoxNjQ3ODc4OTY4fQ.ZrDe2eIth7MGIjTmv9LeM3Li3XUHXfzxIPp-5iZBcdI",
        "Content-Type: application/json",
        "Accept: application/json"
    })
    @GET("v1/auth/me")
    Call<JsonObject> validacion();
}
