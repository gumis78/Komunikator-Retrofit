package com.example.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit
{
    private static Retrofit retrofit;

    //Adres skryptu do obsługi danych (musi zaczynać się od http lub https)
    private final static String BASE_URL = "https://www.dte.com.pl/script/";

    //Funkcja zwraca instancję obiektu Retrofit
    public static Retrofit getRetrofitInstance()
    {
        if(retrofit == null)
        {
            //Instancja Retrofit
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
