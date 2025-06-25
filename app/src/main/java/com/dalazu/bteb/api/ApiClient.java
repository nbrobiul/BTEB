package com.dalazu.bteb.api;

import com.dalazu.bteb.model.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("/api/result")
    Call<List<Result>> getResult(
            @Query("year") int year,
            @Query("semester") int semester,
            @Query("roll") String roll
    );

    );
}
