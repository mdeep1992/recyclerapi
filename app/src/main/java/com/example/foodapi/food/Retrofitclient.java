package com.example.foodapi.food;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclient {
    private static Retrofit retrofit;
    private static String BASE_URL ="https://api.jsonbin.io/v3/";
    public static Retrofit getRetrofitinstance(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }return retrofit;
    }
}

