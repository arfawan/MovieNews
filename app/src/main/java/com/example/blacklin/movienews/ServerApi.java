package com.example.blacklin.movienews;

public class
ServerApi {

    public static final String BASE_URL_API = "https://api.themoviedb.org/";

    public static ApiMov getAPIService(){
        return ApiClient.getClient(BASE_URL_API).create(ApiMov.class);
    }

}