package com.example.karthik.delta3;

/**
 * Created by karthik on 29-06-2018.
 */


import com.example.karthik.delta3.CharcterByName.CharacterResponse;
import com.example.karthik.delta3.CharcterByName.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIinterface {
    @GET("api/characters/{name}")
    Call<CharacterResponse> getCharacter(@Path("name") String name);


}
