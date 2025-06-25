package com.dalazu.bteb.api;

import com.dalazu.bteb.model.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {


    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(3600, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Result.class, new ResultDeserializer()) // Register custom deserializer
            .create();

    private static final Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson)) // Use custom Gson
                    .client(okHttpClient);

    private static final Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
