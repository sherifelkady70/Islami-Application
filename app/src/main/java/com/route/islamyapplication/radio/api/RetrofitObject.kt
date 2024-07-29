package com.route.islamyapplication.radio.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private var retrofit : Retrofit?=null

    fun getRetrofitInstance() : RadiosService {
        if(retrofit==null){
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://mp3quran.net/api/v3/")
                .build()
        }
        return retrofit!!.create(RadiosService::class.java)
    }
}