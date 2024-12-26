package com.aarav.f1clone.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static Retrofit retrofit = null;
    public static String BASE_URL = "https://api.jolpi.ca/";

    public static DriverApiService getService(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(DriverApiService.class);
    }
}
