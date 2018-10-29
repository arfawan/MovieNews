package com.example.blacklin.movienews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseM {


    @SerializedName("results")
    @Expose
    private List<Origin> movies = null;

    public ResponseM( List<Origin> movies) {

        this.movies = movies;
    }

    public List<Origin> getMovies() {
        return movies;
    }

}
