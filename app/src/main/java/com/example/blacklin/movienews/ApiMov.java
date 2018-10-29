package com.example.blacklin.movienews;

import com.example.blacklin.movienews.ResponseM;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiMov {

    @GET("/3/movie/now_playing")
    Call<ResponseM> getNowPlayingMovie(@Query("api_key") String api_key,
                                       @Query("language") String language);



}

