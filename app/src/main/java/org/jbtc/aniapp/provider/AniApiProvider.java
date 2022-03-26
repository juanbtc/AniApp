package org.jbtc.aniapp.provider;

import org.jbtc.aniapp.utils.ConfigVar;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AniApiProvider {
    private static Retrofit INSTANCE =null;

    public static Retrofit getInstance(){
        if(INSTANCE ==null) {
            synchronized (AniApiProvider.class) {
                if(INSTANCE ==null) {
                    OkHttpClient cliente = new OkHttpClient.Builder()
                            .addInterceptor(new Interceptor() {
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request request = chain.request();
                                    Request.Builder newRequest = request.newBuilder().header("Authorization", ConfigVar.KEY_JWT);
                                    return chain.proceed(newRequest.build());
                                }
                            }).build();

                    INSTANCE = new Retrofit.Builder()
                            .client(cliente)
                            .baseUrl(ConfigVar.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
