package com.example.karthik.delta3;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by karthik on 03-07-2018.
 */

public class RetrofitClient {
   private static final String BASE_URL = "https://api.got.show/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
       if (retrofit==null)
       {
           retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();



       }
        return retrofit;
    }
}
