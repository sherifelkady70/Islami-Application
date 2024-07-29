package com.route.islamyapplication.radio.api

import com.route.islamyapplication.radio.api.models.RadiosResponse
import retrofit2.http.GET

interface RadiosService {
    @GET("radios")
    suspend fun getRadios() : RadiosResponse
}