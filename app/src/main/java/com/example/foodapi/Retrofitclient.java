package com.example.foodapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclient {
    private static Retrofit retrofit;
    private static String BASE_URL ="https://hf-android-app.s3-eu-west-1.amazonaws.com/";
    public static Retrofit getRetrofitinstance(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }return retrofit;
    }
}
