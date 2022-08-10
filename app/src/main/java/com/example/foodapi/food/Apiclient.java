package com.example.foodapi.food;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Apiclient {
    @Headers("X-MASTER-KEY: $2b$10$3L3b4GDMfCWoEi6P4jZDC.mpU/390GC/fOxyFfK.4iLBPUP4J0W/u")
    @GET("b/62edf1d8a1610e6386f0d9a5")
    Call<Model> getAllData();
}
