package com.example.musicmelody.remote;

import com.example.musicmelody.model.charts.ChartsModel;
import com.example.musicmelody.model.search.SearchModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers({"x-rapidapi-host:shazam.p.rapidapi.com","x-rapidapi-key:1e1bc31e4emsh4a4cf872af6df1dp1d1534jsn6e974df2e190"})
    @GET("/charts/track?locale=en-US&pageSize=20&startFrom=0")
    Call<ChartsModel> getcharts();

    @Headers({"x-rapidapi-host:shazam.p.rapidapi.com","x-rapidapi-key:1e1bc31e4emsh4a4cf872af6df1dp1d1534jsn6e974df2e190"})
    @GET("/search?locale=en-US&offset=0&limit=5")
    Call<SearchModel> getSearch(@Query("term") String text);

}
