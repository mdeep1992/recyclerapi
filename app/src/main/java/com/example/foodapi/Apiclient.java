package com.example.foodapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiclient {
    @GET("android-test/recipes.json\n")
     Call<ModelApi> getAllData();
}
